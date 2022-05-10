package com.kakaopaysec.api.global.exception;

import com.kakaopaysec.api.global.exception.errors.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    // 클라이언트로 에러를 반환하기 위한 DTO클래스
    private final int status;
    private final String code;
    private final String message;

    ErrorResponse (ErrorCodes errorCodes) {
        status = errorCodes.getStatus();
        code = errorCodes.getCode();
        message = errorCodes.getMessage();
    }
}
