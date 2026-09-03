package com.pramila.financing.service;


import com.pramila.financing.entity.Customer;
import com.pramila.financing.entity.FinancingProduct;
import com.pramila.financing.entity.FinancingRequest;
import com.pramila.financing.entity.FinancingRequestStatus;
import com.pramila.financing.exceptions.CustomerNotFoundException;
import com.pramila.financing.exceptions.FinancingProductNotFoundException;
import com.pramila.financing.repository.CustomerRepository;
import com.pramila.financing.repository.FinancingProductRepository;
import com.pramila.financing.repository.FinancingRequestRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FinancingRequestService {
    private final CustomerRepository customerRepository;
    private final FinancingProductRepository financingProductRepository;
    private final FinancingRequestRepository financingRequestRepository;

    //Why final?
    //Because these dependencies should be provided when
    // the service is created and shouldn't be replaced later.
    public FinancingRequestService(CustomerRepository customerRepository,FinancingProductRepository financingProductRepository,FinancingRequestRepository financingRequestRepository){
        this.customerRepository = customerRepository;
        this.financingProductRepository = financingProductRepository;
        this.financingRequestRepository = financingRequestRepository;
    }

    public FinancingRequest createFinancingRequest(Long customerId, Long productId, BigDecimal requestedAmount, Integer tenureMonths){
        Customer customer = customerRepository.findById(customerId).orElseThrow(()->
                new CustomerNotFoundException("Customer not founf with id: "+ customerId));
        FinancingProduct product = financingProductRepository.findById(productId).orElseThrow(()->
                new FinancingProductNotFoundException("Product with Id "+productId+" not found"));

        if(requestedAmount.compareTo(product.getMinAmount()) < 0 || //using compareTo() because requestedAmount is in BigDecimal so java won't allow normal operators
        requestedAmount.compareTo(product.getMaxAmount()) > 0){
            throw new IllegalArgumentException("RequestedAmount must be between "+product.getMinAmount()+" and "+product.getMaxAmount());
        }

        if(tenureMonths < product.getMinTenureMonths() || tenureMonths > product.getMaxTenureMonths()){
            throw new IllegalArgumentException("RequestedAmount must be between "+product.getMinTenureMonths()+" and "+product.getMinTenureMonths());
        }

        FinancingRequest request = new FinancingRequest();
        request.setCustomer(customer);
        request.setProduct(product);
        request.setRequestedAmount(requestedAmount);
        request.setTenureMonths(tenureMonths);
        request.setStatus(FinancingRequestStatus.CANCELLED);
        FinancingRequest savedRequest = financingRequestRepository.save(request);

    return savedRequest;
    }
}
