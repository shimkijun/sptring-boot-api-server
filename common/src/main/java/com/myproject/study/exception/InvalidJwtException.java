package com.myproject.study.exception;

public class InvalidJwtException extends RuntimeException{
    public InvalidJwtException(String msg){
        super(msg);
    }
}
