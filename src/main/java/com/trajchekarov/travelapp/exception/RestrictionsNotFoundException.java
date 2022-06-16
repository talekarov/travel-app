package com.trajchekarov.travelapp.exception;

public class RestrictionsNotFoundException extends RuntimeException{

    public RestrictionsNotFoundException() {
        super();
    }

    public RestrictionsNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public  RestrictionsNotFoundException(final String message) {
        super(message);
    }

    public RestrictionsNotFoundException(final Throwable cause){
        super(cause);
    }
}
