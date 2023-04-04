package com.example.discountservice.service.api;

import com.example.discountservice.controller.dto.client.ClientCreateRequest;
import com.example.discountservice.controller.dto.client.ClientResponse;
import com.example.discountservice.controller.dto.point.PointsResponse;
import lombok.NonNull;

import java.util.UUID;

public interface ClientService {

    /**
     * Метод создает нового клиента
     *
     * @param client - минимальная информация для создания клиента.
     */
    void createClient(@NonNull ClientCreateRequest client);

    /**
     * Метод записывает в бд количество балов.
     *
     * @param cardNumber - номер карты.
     * @param sum        - общая сумма по этой карте.
     */
    void recordingPointsForTheClientByCardNumber(@NonNull String cardNumber, @NonNull Double sum);

    /**
     * Получение информации о балах клиента по id в БД.
     *
     * @param id - идентификатор клиента в БД
     * @return - Количество доступных балов.
     */
    PointsResponse getPointsById(@NonNull UUID id);

    /**
     * Метод создает нового клиента
     *
     * @param id - id клиента.
     */
    ClientResponse getClientById(@NonNull UUID id);
}
