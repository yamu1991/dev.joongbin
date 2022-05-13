package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

public class AccountCommand {

    @Getter
    @Builder
    public static class RegisterAccountRequest {
        private final Long userId;

        public Account toEntity(User user) {
            return Account.builder()
                    .user(user)
                    .build();
        }
    }
}
