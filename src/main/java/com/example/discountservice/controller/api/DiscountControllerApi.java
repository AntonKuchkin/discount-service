package com.example.discountservice.controller.api;

import com.example.discountservice.controller.dto.check.CheckRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Set;

@Tag(name = "API сервиса накопления скидочных балов")
public interface DiscountControllerApi {

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Обработка чеков и начисление балов")
    void checkProcessingAndPointsAccrual (@RequestBody Set<CheckRequest> checks);
}
