package com.example.discountservice.service.impl;

import com.example.discountservice.controller.dto.Points;
import com.example.discountservice.controller.dto.check.CheckRequest;
import com.example.discountservice.entity.CheckEntity;
import com.example.discountservice.entity.ClientEntity;
import com.example.discountservice.exception.ClientNotFoundException;
import com.example.discountservice.mapper.DiscountMapper;
import com.example.discountservice.repository.ClientRepository;
import com.example.discountservice.service.api.CheckService;
import com.example.discountservice.service.api.DiscountService;
import com.example.discountservice.service.api.ScoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final ClientRepository clientRepository;
    private final DiscountMapper mapper;
    private final ScoringService scoringService;
    private final CheckService checkService;

    @Override
    public Points getPointsById(UUID id) {

        return mapper.clientEntityToPoints(clientRepository.findById(id).orElseThrow(
                () -> ClientNotFoundException.createById(id)));
    }

    @Override
    public void checkProcessingAndPointsAccrual(Set<CheckRequest> checks) {
        List<CheckEntity> checkEntities = mapper.checkDtoListToChecksEntity(checks);
        scoring(checkEntities);
    }

    /**
     * Метод выбирает чеки с одинаковыми картами и начисляет баллы на каждую карту.
     *
     * @param checks - Лист чеков совершенных покупок
     */
    private void scoring(List<CheckEntity> checks) {
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
            recordingPointsForTheClientByCardNumber(checks.get(i).getCardNumber(), sumClient);
            sumClient = 0.0;
        }
    }


    /**
     * Метод записывает в бд количество балов.
     *
     * @param cardNumber - номер карты.
     * @param sum        - общая сумма по этой карте.
     */
    private void recordingPointsForTheClientByCardNumber(String cardNumber, Double sum) {
        ClientEntity client = clientRepository.findByCardNumber(cardNumber);
        client.setNumberOfPoints(scoringService.countPoints(sum));
        clientRepository.save(client);
    }

}
