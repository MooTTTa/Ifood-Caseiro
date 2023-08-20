package com.supermarket.supermarket.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object obj){
        super("Resource Not Found. id: " + obj);
    }

}
