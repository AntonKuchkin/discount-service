package com.example.discountservice.controller.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientCreateRequest {

    @Length(min = 20, max = 20)
    @JsonProperty(required = true)
    @Schema(description = "Номер карты")
    private String cardNumber;
}
