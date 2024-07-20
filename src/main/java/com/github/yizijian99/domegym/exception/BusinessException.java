package com.github.yizijian99.domegym.exception;

@SuppressWarnings("FieldCanBeLocal")
public class BusinessException extends RuntimeException {
    private final IError error;
    private final Object[] args;

    public BusinessException(IError error, Object ...args) {
        super(error.getCode());
        this.error = error;
        this.args = args;
    }
}
