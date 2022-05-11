package com.kakaopaysec.api.global.response.http;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
// 맞는 타입으로 cast 하기때문에 typeError가 일어날 수 없다
@SuppressWarnings("unchecked")
public class CommonResponse<T> {
    private T data;
    private String message;

    public static <T> CommonResponse<T> success(T data, String message) {
        return (CommonResponse<T>) CommonResponse.builder()
                .data(data)
                .message(message)
                .build();
    }

    public static <T> CommonResponse<T> success(T data) {
        return success(data, null);
    }
}
