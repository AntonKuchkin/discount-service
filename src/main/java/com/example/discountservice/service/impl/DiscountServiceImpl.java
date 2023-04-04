package com.example.discountservice.service.impl;

import com.example.discountservice.controller.dto.check.CheckRequest;
import com.example.discountservice.entity.CheckEntity;
import com.example.discountservice.mapper.DiscountMapper;
import com.example.discountservice.service.api.CheckService;
import com.example.discountservice.service.api.ClientService;
import com.example.discountservice.service.api.DiscountService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountMapper mapper;
    private final CheckService checkService;
    private final ClientService clientService;

    @Override
    public void checkProcessingAndPointsAccrual(@NonNull Set<CheckRequest> checks) {
        List<CheckEntity> checkEntities = mapper.checkDtoListToChecksEntity(checks);
        scoring(checkEntities);
    }

    /**
     * Метод выбирает чеки с одинаковыми картами и начисляет баллы на каждую карту.
     *
     * @param checks - Лист чеков совершенных покупок
     */
    private void scoring(@NonNull List<CheckEntity> checks) {
        List<CheckEntity> checkSameCardNumber = new ArrayList<>();
        Double sumClient = 0.0;
        for (int i = 0; i < checks.size(); i++) {
            for (int j = 0; j < checks.size(); j++) {
                if ((checkService.checkingForPresenceInTheDatabase(checks.get(j))) &&
                        (checks.get(i).getCardNumber().equals(checks.get(j).getCardNumber()))) {
                    checkSameCardNumber.add(checks.get(j));
                }
            }
            for (CheckEntity check : checkSameCardNumber) {
                sumClient = sumClient + check.getSum();
            }
            clientService.recordingPointsForTheClientByCardNumber(checks.get(i).getCardNumber(), sumClient);
            sumClient = 0.0;
        }
    }


}
