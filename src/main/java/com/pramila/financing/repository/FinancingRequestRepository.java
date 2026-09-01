package com.pramila.financing.repository;

import com.pramila.financing.entity.FinancingRequest;
import com.pramila.financing.entity.FinancingRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancingRequestRepository extends JpaRepository<FinancingRequest,Long> {

    List<FinancingRequest> findByCustomerCustomerId(Long customerId);

    List<FinancingRequest> findByStatus(FinancingRequestStatus status);
}
