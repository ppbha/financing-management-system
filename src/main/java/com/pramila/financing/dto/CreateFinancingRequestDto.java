package com.pramila.financing.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateFinancingRequestDto {

    @NotNull
    @Positive
    private Long customerId;

    @NotNull
    @Positive
    private Long productId;

    @NotNull
    @Positive
    private BigDecimal requestedAmount;

    @NotNull
    @Positive
    private Integer tenureMonths;
}
