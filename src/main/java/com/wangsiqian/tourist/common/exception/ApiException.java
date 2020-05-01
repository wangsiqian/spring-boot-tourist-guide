package com.wangsiqian.tourist.common.exception;

import lombok.Getter;

/** @author wangsiqian */
@Getter
public class ApiException extends RuntimeException {
    protected String errorType;
    protected String message;

    public ApiException(String errorType, String message) {
        super(format(errorType, message));

        this.errorType = errorType;
        this.message = message;
    }

    private static String format(String errorType, String message) {
        return String.format("ApiException[%s]:%s", errorType, message);
    }
}
