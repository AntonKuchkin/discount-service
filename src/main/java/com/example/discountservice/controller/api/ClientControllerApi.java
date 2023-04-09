package com.example.discountservice.controller.api;

import com.example.discountservice.controller.dto.client.ClientCreateRequest;
import com.example.discountservice.controller.dto.client.ClientResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Tag(name = "API сервиса клиентов")
public interface ClientControllerApi {

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Заведение нового клиента")
    void createClient(@RequestBody ClientCreateRequest clientCreateRequest);

    @GetMapping("/{cardNumber}")
    @Operation(summary = "Полyчение клиента по номеру карты")
    ClientResponse getClient(@PathVariable String cardNumber);

}
