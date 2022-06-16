package com.trajchekarov.travelapp.exception;

public class FlightNotFoundException extends RuntimeException{

    public FlightNotFoundException() {
        super();
    }

    public FlightNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public  FlightNotFoundException(final String message) {
        super(message);
    }

    public FlightNotFoundException(final Throwable cause){
        super(cause);
    }
}

