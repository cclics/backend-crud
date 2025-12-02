package com.bucannera.street;

public class StreetNotFoundException extends RuntimeException {

    public StreetNotFoundException(Long id) {
        super("Could not find street " + id);
    }
}
