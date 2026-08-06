package com.healthclinic.exception;

public class ValidationExpection extends RuntimeException{
    public ValidationExpection(String message){
        super(message);
    }
}
