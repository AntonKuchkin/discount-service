package com.example.discountservice.controller.dto.check;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckPositionRequest {

    @Schema(description = "Сумма по позиции")
    private Integer positionAmount;
}
