package com.asg.palindrom.exception;

import java.time.LocalDateTime;

public class ErrorDetails<T>{


    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;

    private boolean success;

    private T errors;

    public ErrorDetails() {
    }

    public ErrorDetails(LocalDateTime timestamp, String message, String path, String errorCode, boolean success,  T errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
        this.success=success;
        this.errors=errors;
    }

    public ErrorDetails(LocalDateTime timestamp, String message, String path, String errorCode, boolean success) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.errorCode = errorCode;
        this.success = success;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getErrors() {
        return errors;
    }

    public void setErrors(T errors) {
        this.errors = errors;
    }
}

