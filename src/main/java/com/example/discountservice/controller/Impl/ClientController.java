package com.example.discountservice.controller.Impl;

import com.example.discountservice.controller.api.ClientControllerApi;
import com.example.discountservice.controller.dto.client.ClientCreateRequest;
import com.example.discountservice.controller.dto.client.ClientResponse;
import com.example.discountservice.controller.dto.point.PointsResponse;
import com.example.discountservice.service.api.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client-service")
@Validated
public class ClientController implements ClientControllerApi {

    private final ClientService clientService;

    @Override
    public void createClient(@NonNull @Valid ClientCreateRequest clientCreateRequest) {
        clientService.createClient(clientCreateRequest);
    }

    @Override
    public ClientResponse getClient(@NonNull UUID idClient) {
        return clientService.getClientById(idClient);
    }

    @Override
    public PointsResponse getPoints(@NonNull UUID idClient) {
        return clientService.getPointsById(idClient);
    }
}
