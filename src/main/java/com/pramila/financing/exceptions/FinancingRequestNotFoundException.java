package com.pramila.financing.exceptions;

public class FinancingRequestNotFoundException extends RuntimeException {
    public FinancingRequestNotFoundException(String message){
        super(message);
    }
}
