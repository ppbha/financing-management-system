package com.pramila.financing.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private FinancingRequest request;

    @ManyToOne
    @JoinColumn(name = "performed_by", nullable = false)
    private Officer performedBy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AuditAction action;

    @Enumerated(EnumType.STRING)
    private FinancingRequestStatus status;

    private String comments;

    @Column(nullable = false)
    private LocalDateTime createdAt;
}
