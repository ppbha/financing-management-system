package com.pramila.financing.exceptions;

public class FinancingProductNotFoundException extends RuntimeException{

    public FinancingProductNotFoundException(String message){
        super (message);
    }
}
