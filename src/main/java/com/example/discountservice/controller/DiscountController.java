package com.example.discountservice.controller;

import com.example.discountservice.controller.api.DiscountControllerApi;
import com.example.discountservice.controller.dto.Points;
import com.example.discountservice.controller.dto.check.CheckRequest;
import com.example.discountservice.service.api.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discount-service")
public class DiscountController implements DiscountControllerApi {

    private final DiscountService discountService;

    @Override
    public Points getPoints(@PathVariable @Min(1) UUID idClient) {
        return discountService.getPointsById(idClient);
    }

    @Override
    public void checkProcessingAndPointsAccrual(Set<CheckRequest> checks) {
        discountService.checkProcessingAndPointsAccrual(checks);
    }

}
