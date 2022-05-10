package com.kakaopaysec.api.global.exception.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// 추후 Exception을 처리하기 위한 클래스
public class BaseException extends RuntimeException {

    // 내부 필드로는 에러를 선언해놓은 ErrorCodes Enum을 가진다
    private final ErrorCodes errorCodes;
}
