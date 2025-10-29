package com.bucannera.post;

public class PostNotFoundException extends RuntimeException {

    PostNotFoundException(Long id) {
        super("Could not find post " + id);
    }
}


