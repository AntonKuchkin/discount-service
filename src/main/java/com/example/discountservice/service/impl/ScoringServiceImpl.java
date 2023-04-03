package com.example.discountservice.service.impl;

import com.example.discountservice.service.api.ScoringService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.discountservice.constant.PointsConstants.AVERAGE_VALUE_OF_THE_BALL;
import static com.example.discountservice.constant.PointsConstants.MAXIMUM_CHECK_AMOUNT;
import static com.example.discountservice.constant.PointsConstants.MAXIMUM_VALUE_OF_THE_BALL;
import static com.example.discountservice.constant.PointsConstants.MINIMUM_CHECK_AMOUNT;
import static com.example.discountservice.constant.PointsConstants.MINIMUM_VALUE_OF_THE_BALL;

@Service
@RequiredArgsConstructor
public class ScoringServiceImpl implements ScoringService {

    @Override
    public Integer countPoints(Double sumOfAllChecks) {
        Integer points = 0;
        if (sumOfAllChecks <= MINIMUM_CHECK_AMOUNT) {
            points = (int) (sumOfAllChecks / MAXIMUM_VALUE_OF_THE_BALL);
        }
        if (sumOfAllChecks > MAXIMUM_VALUE_OF_THE_BALL && sumOfAllChecks <= MAXIMUM_CHECK_AMOUNT) {
            points = (int) (sumOfAllChecks / AVERAGE_VALUE_OF_THE_BALL);
        }
        if (sumOfAllChecks > MAXIMUM_CHECK_AMOUNT) {
            points = (int) (sumOfAllChecks / MINIMUM_VALUE_OF_THE_BALL);
        }
        return points;
    }
}
