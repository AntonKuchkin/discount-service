package com.example.discountservice.service.api;

import com.example.discountservice.controller.dto.client.ClientCreateRequest;
import com.example.discountservice.controller.dto.client.ClientResponse;
import com.example.discountservice.entity.ClientEntity;
import lombok.NonNull;

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
     * Получение информации о балах клиента по номеру карты в БД.
     *
     * @param cardNumber - номер карты.
     * @return - Количество доступных балов.
     */
    ClientResponse getClientByCardNumber(@NonNull String cardNumber);

    /**
     * Получение сущности клиента по номеру карты в БД.
     *
     * @param cardNumber - номер карты.
     * @return - сущность клиента.
     */
    ClientEntity getClientEntityByCardNumber(String cardNumber);
}
