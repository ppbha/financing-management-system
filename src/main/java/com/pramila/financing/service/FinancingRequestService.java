package com.pramila.financing.service;


import com.pramila.financing.repository.CustomerRepository;
import com.pramila.financing.repository.FinancingProductRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancingRequestService {
    private final CustomerRepository customerRepository;
    private final FinancingProductRepository financingProductRepository;

    //Why final?
    //Because these dependencies should be provided when
    // the service is created and shouldn't be replaced later.
    public FinancingRequestService(CustomerRepository customerRepository,FinancingProductRepository financingProductRepository){
        this.customerRepository = customerRepository;
        this.financingProductRepository = financingProductRepository;
    }
}
