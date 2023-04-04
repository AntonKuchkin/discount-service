package com.example.discountservice.controller.Impl;

import com.example.discountservice.controller.api.DiscountControllerApi;
import com.example.discountservice.controller.dto.check.CheckRequest;
import com.example.discountservice.service.api.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/discount-service")
public class DiscountController implements DiscountControllerApi {

    private final DiscountService discountService;

    @Override
    public void checkProcessingAndPointsAccrual(Set<CheckRequest> checks) {
        discountService.checkProcessingAndPointsAccrual(checks);
    }

}
