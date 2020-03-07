package com.myproject.study.exception;

public class EmailExistedException extends RuntimeException{

    public EmailExistedException(String email){
        super(email + "메일은 이미 존재합니다");
    }

}
