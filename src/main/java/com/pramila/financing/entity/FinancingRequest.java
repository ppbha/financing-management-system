package com.pramila.financing.entity;

import jakarta.persistence.*;

import javax.swing.*;
import java.math.BigInteger;
import java.time.LocalDateTime;

public class FinancingRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @ManyToOne
    @JoinColumn(name = "product_Id", nullable = false)
    private FinancingProduct product;

    @ManyToOne
    @JoinColumn(name = "customer_Id", nullable = false)
    private Customer customer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FinancingRequestStatus status;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigInteger requestedAmount;

//    @Column(precision = 5, scale = 2, nullable = false)
//    private BigInteger appliedInterestRate;

    @Column(nullable = false)
    private Integer tenureMonths;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }


}

