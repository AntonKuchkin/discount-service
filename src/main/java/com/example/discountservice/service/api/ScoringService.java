package com.example.discountservice.service.api;

public interface ScoringService {

    /**
     * Метод вычисляет количество балов в зависимости от покупки
     *
     * @param sumOfAllChecks - Общая сумма по чекам.
     */
    Integer countPoints(Double sumOfAllChecks);
}
