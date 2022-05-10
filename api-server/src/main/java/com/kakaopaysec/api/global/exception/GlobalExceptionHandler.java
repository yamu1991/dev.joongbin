package com.kakaopaysec.api.global.exception;

import com.kakaopaysec.api.global.exception.errors.BaseException;
import com.kakaopaysec.api.global.exception.errors.ErrorCodes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    // 예상된 에러가 발생됐을 경우 해당 에러에 맞게 처리하여 준다
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> BaseExceptionHandler(BaseException ex) {
        ErrorCodes errorCodes = ex.getErrorCodes();
        log.debug("Base exception occurred : {}  {}  {}",
                errorCodes.getStatus(), errorCodes.getCode(), errorCodes.getMessage());

        return ResponseEntity
                .status(errorCodes.getStatus())
                .body(new ErrorResponse(errorCodes));
    }

    // 예상치 못한 에러가 발생했을 때에는 Internal server error 에러를 반환하고 로그를 찍는다
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> UnexpectedExceptionHandler(Exception ex) {
        ex.printStackTrace();
        log.error("UnexpectedException occurred : {}", ex);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .body(new ErrorResponse(ErrorCodes.INTERNAL_SERVER_ERROR));
    }
}
