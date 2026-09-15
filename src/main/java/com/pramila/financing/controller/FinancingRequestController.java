package com.pramila.financing.controller;


import com.pramila.financing.dto.CreateFinancingRequestDto;
import com.pramila.financing.entity.FinancingRequest;
import com.pramila.financing.service.FinancingRequestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/financing-requests")
public class FinancingRequestController {

    private final FinancingRequestService financingRequestService;

    public FinancingRequestController( FinancingRequestService financingRequestService){
        this.financingRequestService = financingRequestService;
    }

    @PostMapping
    public FinancingRequest createFinancingRequest(@RequestBody @Valid CreateFinancingRequestDto dto){
        return financingRequestService.createFinancingRequest(dto);
    }

}
