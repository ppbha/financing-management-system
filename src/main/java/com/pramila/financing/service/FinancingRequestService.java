package com.pramila.financing.service;


import com.pramila.financing.dto.CreateFinancingRequestDto;
import com.pramila.financing.dto.FinancingRequestResponseDto;
import com.pramila.financing.entity.Customer;
import com.pramila.financing.entity.FinancingProduct;
import com.pramila.financing.entity.FinancingRequest;
import com.pramila.financing.entity.FinancingRequestStatus;
import com.pramila.financing.exceptions.CustomerNotFoundException;
import com.pramila.financing.exceptions.FinancingProductNotFoundException;
import com.pramila.financing.exceptions.InvalidFinancingRequestException;
import com.pramila.financing.repository.CustomerRepository;
import com.pramila.financing.repository.FinancingProductRepository;
import com.pramila.financing.repository.FinancingRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;


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

    public FinancingRequestResponseDto createFinancingRequest(CreateFinancingRequestDto dto){
        Customer customer = customerRepository.findById(dto.getCustomerId()).orElseThrow(()->
                new CustomerNotFoundException("Customer not found with id: "+ dto.getCustomerId()));
        FinancingProduct product = financingProductRepository.findById(dto.getProductId()).orElseThrow(()->
                new FinancingProductNotFoundException("Product with Id "+dto.getProductId()+" not found"));

        if(dto.getRequestedAmount().compareTo(product.getMinAmount()) < 0 || //using compareTo() because requestedAmount is in BigDecimal so java won't allow normal operators
        dto.getRequestedAmount().compareTo(product.getMaxAmount()) > 0){
            throw new InvalidFinancingRequestException("RequestedAmount must be between "+product.getMinAmount()+" and "+product.getMaxAmount());
        }

        if(dto.getTenureMonths() < product.getMinTenureMonths() || dto.getTenureMonths() > product.getMaxTenureMonths()){
            throw new InvalidFinancingRequestException(
                    "Tenure must be between "
                            + product.getMinTenureMonths()
                            + " and "
                            + product.getMaxTenureMonths()
                            + " months"
            );        }

        FinancingRequest request = new FinancingRequest();
        request.setCustomer(customer);
        request.setProduct(product);
        request.setRequestedAmount(dto.getRequestedAmount());
        request.setTenureMonths(dto.getTenureMonths());
        request.setStatus(FinancingRequestStatus.SUBMITTED);
        FinancingRequest savedRequest = financingRequestRepository.save(request);

    return mapToResponseDto(savedRequest);
    }

    private FinancingRequestResponseDto mapToResponseDto(FinancingRequest request){
        FinancingRequestResponseDto response = new FinancingRequestResponseDto();

        response.setRequestId(request.getRequestId());
        response.setCustomerId(request.getCustomer().getCustomerId());
        response.setProductId(request.getProduct().getProductId());
        response.setRequestedAmount(request.getRequestedAmount());
        response.setTenureMonths(request.getTenureMonths());
        response.setStatus(request.getStatus());
        response.setCreatedAt(request.getCreatedAt());
        response.setUpdatedAt(request.getUpdatedAt());

        return response;
    }

    public List<FinancingRequestResponseDto> getRequestByCustomer(Long customerId){

        customerRepository.findById(customerId)
                .orElseThrow(()->
                        new CustomerNotFoundException(
                                "Customer not found with id: "+ customerId
                        ));
        List<FinancingRequest> requests = financingRequestRepository.findByCustomerCustomerId(customerId);

        return  requests.stream()
                .map((this::mapToResponseDto))
                .toList();
    }
}
