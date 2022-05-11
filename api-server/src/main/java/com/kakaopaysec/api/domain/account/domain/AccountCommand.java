package com.kakaopaysec.api.domain.account.domain;

import lombok.Builder;
import lombok.Getter;

public class AccountCommand {

    @Getter
    @Builder
    public static class RegisterAccountRequest {
        // Id 같은경우 메일 답변에 따라 달리 질 수 있음
        private final Long userId;

        public Account toEntity() {
            return Account.builder()
                    .userId(userId)
                    .build();
        }
    }
}
