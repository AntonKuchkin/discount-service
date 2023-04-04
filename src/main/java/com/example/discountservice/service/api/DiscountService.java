package com.example.discountservice.service.api;

import com.example.discountservice.controller.dto.check.CheckRequest;
import com.example.discountservice.controller.dto.point.PointsResponse;
import lombok.NonNull;

import java.util.Set;
import java.util.UUID;

public interface DiscountService {

    /**
     * Получение нескольких чеков и зачисление балов
     *
     * @param checks - входящие чеки
     */
    void checkProcessingAndPointsAccrual(@NonNull Set<CheckRequest> checks);
}
