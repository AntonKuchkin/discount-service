package com.example.discountservice.exception;

import java.util.UUID;

public class ClientNotFoundException extends BaseNotFoundException {

    private static final String CLIENT_NOT_FOUND_ERROR = "Клиента не найден, id: %s";

    protected ClientNotFoundException(String message) {
        super(message);
    }

    public static ClientNotFoundException createById(UUID id) {
        String message = String.format(CLIENT_NOT_FOUND_ERROR, id);
        return new ClientNotFoundException(message);
    }

}
