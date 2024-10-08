package com.t2.dsw.concesionaria_t2.exception;

public class ResourceNotFoundException
    extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
