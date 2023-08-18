package com.akr.business.url.shortner.redirection.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {

    private int errorCode;
    private String message;
    private Throwable throwable;

    public ServiceException(int errorCode, String message){
        super(getExceptionString(errorCode,message));
        this.errorCode = errorCode;
        this.message = message;
    }
    public ServiceException(ExceptionMessages exceptionMessages){
        super(getExceptionString(exceptionMessages));
        this.errorCode = exceptionMessages.getErrorCode();
        this.message = exceptionMessages.getMessage();
    }
    public ServiceException(ExceptionMessages exceptionMessages, Exception exception){
        super(getExceptionString(exceptionMessages),exception);
        this.errorCode = exceptionMessages.getErrorCode();
        this.message = exceptionMessages.getMessage();
        this.throwable = exception;
    }

    private static String getExceptionString(ExceptionMessages exceptionMessages) {
        return getExceptionString(exceptionMessages.getErrorCode(),exceptionMessages.getMessage());
    }
    private static String getExceptionString(int errorCode, String message) {
        return "[ ErrorCode:" + errorCode + ", message:" + message + " ]";
    }
}
