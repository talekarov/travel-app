package com.trajchekarov.travelapp.exception;

public class VaccinationStatusNotFoundException extends RuntimeException{

    public VaccinationStatusNotFoundException() {
        super();
    }

    public VaccinationStatusNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public  VaccinationStatusNotFoundException(final String message) {
        super(message);
    }

    public VaccinationStatusNotFoundException(final Throwable cause){
        super(cause);
    }
}
