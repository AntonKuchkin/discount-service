package com.example.discountservice.service.api;

import com.example.discountservice.controller.dto.Points;
import com.example.discountservice.controller.dto.check.CheckRequest;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

public interface DiscountService {

    /**
     * Получение информации о балах клиента по id в БД.
     *
     * @param id - идентификатор клиента в БД
     * @return - Количество доступных балов.
     */
    Points getPointsById(@NotNull UUID id);

    /**
     * Получение нескольких чеков и зачисление балов
     *
     * @param checks - входящие чеки
     */
    void checkProcessingAndPointsAccrual(@RequestBody Set<CheckRequest> checks);
}
