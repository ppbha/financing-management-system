package com.pramila.financing.controller;


import com.pramila.financing.dto.CreateFinancingRequestDto;
import com.pramila.financing.dto.FinancingRequestResponseDto;

import com.pramila.financing.service.FinancingRequestService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/financing-requests")
public class FinancingRequestController {

    private final FinancingRequestService financingRequestService;

    public FinancingRequestController( FinancingRequestService financingRequestService){
        this.financingRequestService = financingRequestService;
    }

    @PostMapping
    public FinancingRequestResponseDto createFinancingRequest(@RequestBody @Valid CreateFinancingRequestDto dto){
        return financingRequestService.createFinancingRequest(dto);
    }

    @GetMapping("/customer/{customerId}")
    public List<FinancingRequestResponseDto> getRequestByCustomer(@PathVariable Long customerId){
        return financingRequestService.getRequestByCustomer(customerId);
    }

    @GetMapping("/{requestId}")
    public FinancingRequestResponseDto getFinancingRequestByID(@PathVariable Long requestId){
        return financingRequestService.getFinancingRequestById(requestId);
    }
}
