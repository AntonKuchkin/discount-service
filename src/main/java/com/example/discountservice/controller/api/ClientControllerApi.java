package com.example.discountservice.controller.api;

import com.example.discountservice.controller.dto.client.ClientCreateRequest;
import com.example.discountservice.controller.dto.client.ClientResponse;
import com.example.discountservice.controller.dto.point.PointsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "API сервиса клиентов")
public interface ClientControllerApi {

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Заведение нового клиента")
    void createClient (@NonNull @Valid ClientCreateRequest clientCreateRequest);

    @GetMapping("/id/{idClient}")
    @Operation(summary = "Полyчение клиента по id")
    ClientResponse getClient(@PathVariable UUID idClient);

    @GetMapping("/{idClient}")
    @Operation(summary = "Полyчение балов по id")
    PointsResponse getPoints(@PathVariable UUID idClient);
}
