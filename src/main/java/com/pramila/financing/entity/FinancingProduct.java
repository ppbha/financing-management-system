package com.pramila.financing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FinancingProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;

    @Column(precision = 5,scale = 2)
    private BigDecimal standardInterestRate;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal minAmount;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal maxAmount;

    private Integer minTenureMonths;
    private Integer maxTenureMonths;

    private boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
