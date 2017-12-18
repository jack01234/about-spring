package com.atguigu.spring.tx;

public class UserAccException extends RuntimeException {
    private static final long serialVersionUID = 3443125609201115165L;

    public UserAccException() {
    }

    public UserAccException(String message) {
        super(message);
    }

    public UserAccException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccException(Throwable cause) {
        super(cause);
    }

    public UserAccException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
