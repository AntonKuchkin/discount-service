package com.example.discountservice.exception;

public class CardNumberNotFoundException extends BaseNotFoundException {

    private static final String NO_CLIENT_FOUND_WITH_THIS_CARD = "Клиент c такой картой не найден : %s";


    protected CardNumberNotFoundException(String message) {
        super(message);
    }

    public static ClientNotFoundException createById(String cardNumber) {
        String message = String.format(NO_CLIENT_FOUND_WITH_THIS_CARD, cardNumber);
        return new ClientNotFoundException(message);
    }
}
