package com.bucannera.street;

import com.bucannera.post.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StreetNotFoundAdvice {

    @ExceptionHandler(StreetNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String streetNotFoundHandler(StreetNotFoundException ex) {
        return ex.getMessage();
    }


}
