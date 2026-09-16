package com.pramila.financing.dto;

import com.pramila.financing.entity.FinancingRequestStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class FinancingRequestResponseDto {
    private Long requestId;
    private Long CustomerId;
    private Long productId;
    private BigDecimal requestedAmount;
    private Integer tenureMonths;
    private FinancingRequestStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
