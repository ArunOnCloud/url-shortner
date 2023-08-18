package com.akr.business.url.shortner.redirection.exception;

import lombok.Getter;

public enum ExceptionMessages {

    REPOSITORY_EXCEPTION(10001001,"Db exception"),
    SERVICE_EXCEPTION(1000100,"Service Exception");


    @Getter
    private int errorCode;
    @Getter
    private String message;

    ExceptionMessages(int errorCode,String message){
        this.errorCode = errorCode;
        this.message = message;
    }

}
