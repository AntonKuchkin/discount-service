package com.example.discountservice.controller.api;

import com.example.discountservice.controller.dto.Points;
import com.example.discountservice.controller.dto.check.CheckRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.Min;
import java.util.Set;
import java.util.UUID;

@Tag(name = "API сервиса накопления скидочных балов")
public interface DiscountControllerApi {

    @GetMapping("/{idClient}")
    @Operation(summary = "Полyчение балов по id")
    Points getPoints(@PathVariable @Min(1) UUID idClient);

    @PatchMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Получение чеков и начисление балов")
    void checkProcessingAndPointsAccrual (@RequestBody Set<CheckRequest> checks);
}
