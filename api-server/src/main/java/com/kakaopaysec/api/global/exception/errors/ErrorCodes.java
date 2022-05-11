package com.kakaopaysec.api.global.exception.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {

    USER_NOT_FOUND(404, "API-404-1", "해당 유저를 찾을 수 없습니다"),
    INTERNAL_SERVER_ERROR(500, "API-500-1", "서버 오류 발생");

    // HttpStatus를 나타내는 필드
    private final int status;
    // 같은 status가 존재할 때 구분하기 위한 고유 코드
    private final String code;
    // 에러 메시지
    private final String message;
}
