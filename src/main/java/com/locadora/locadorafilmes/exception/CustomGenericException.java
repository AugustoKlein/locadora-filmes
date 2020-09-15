package com.locadora.locadorafilmes.exception;

public class CustomGenericException extends RuntimeException{

    public CustomGenericException(){
        super();
    }

    public CustomGenericException(final String message, final Throwable cause){
        super(message, cause);
    }

    public CustomGenericException(final String message){
        super(message);
    }

    public CustomGenericException(final Throwable cause) {
        super(cause);
    }
}