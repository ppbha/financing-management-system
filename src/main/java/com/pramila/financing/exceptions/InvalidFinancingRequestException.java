package com.pramila.financing.exceptions;

public class InvalidFinancingRequestException extends RuntimeException{
    public InvalidFinancingRequestException(String message){
        super (message);
    }
}
