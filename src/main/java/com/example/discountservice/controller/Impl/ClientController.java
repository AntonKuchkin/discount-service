package com.example.discountservice.controller.Impl;

import com.example.discountservice.controller.api.ClientControllerApi;
import com.example.discountservice.controller.dto.client.ClientCreateRequest;
import com.example.discountservice.controller.dto.client.ClientResponse;
import com.example.discountservice.service.api.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client-service")
public class ClientController implements ClientControllerApi {

    private final ClientService clientService;

    @Override
    public void createClient(@Valid @RequestBody ClientCreateRequest clientCreateRequest) {
        clientService.createClient(clientCreateRequest);
    }

    @Override
    public ClientResponse getClient(@NonNull String cardNumber) {
        return clientService.getClientByCardNumber(cardNumber);
    }
}
