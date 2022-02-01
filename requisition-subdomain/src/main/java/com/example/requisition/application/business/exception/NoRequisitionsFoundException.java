package com.example.requisition.application.business.exception;

@SuppressWarnings("serial")
public class NoRequisitionsFoundException extends RuntimeException {

    public NoRequisitionsFoundException(String message){
        super(message);
    }

}
