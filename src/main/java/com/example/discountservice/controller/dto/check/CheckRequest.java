package com.example.discountservice.controller.dto.check;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckRequest {

    @Schema(description = "id чека")
    private UUID id;

    @NotNull
    @Pattern(regexp = "\\d")
    @Length(min = 20, max = 20)
    @Schema(description = "Номер карты")
    private String cardNumber;

    @Schema(description = "Сумма чека")
    private Integer sum;
}
