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
public class CreditAssessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assessmentId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private FinancingRequest request;

    @Column(nullable = false)
    private Integer cibilScore;

    @Column(precision = 5, scale = 2, nullable = false)
    private BigDecimal debtToIncomeRatio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CreditAssessmentStatus assessmentStatus;

    private String comments;

    @Column(nullable = false)
    private LocalDateTime assessedAt;

    @ManyToOne
    @JoinColumn(name = "assessed_by", nullable = false)
    private Officer assessedBy;
}
