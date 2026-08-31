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
public class FinancingRequestReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private FinancingRequest request;

    @ManyToOne
    @JoinColumn(name = "officer_id", nullable = false)
    private Officer officer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewStatus reviewStatus;

    @Column(precision = 19, scale = 2)
    private BigDecimal approvedAmount;

    @Column(precision = 5, scale = 2)
    private BigDecimal appliedInterestRate;

    private String comments;

    @Column(nullable = false)
    private LocalDateTime reviewedAt;

}
