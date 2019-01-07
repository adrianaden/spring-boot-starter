package com.adrianaden.springboot.starter.exception;

public class NoObjectFoundException extends IllegalStateException {

    public static final int STATUS_CODE = 404;

    public NoObjectFoundException() {
        super("No Object Found");
    }
}
