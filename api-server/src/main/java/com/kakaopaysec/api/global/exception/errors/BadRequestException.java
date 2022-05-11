package com.kakaopaysec.api.global.exception.errors;

public class BadRequestException extends BaseException {

    public BadRequestException(String message) {
        super(ErrorCodes.BAD_REQUEST);
        getErrorCodes().setMessage(message);
    }
}
