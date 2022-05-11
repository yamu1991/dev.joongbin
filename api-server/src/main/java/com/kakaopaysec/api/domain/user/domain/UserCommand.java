package com.kakaopaysec.api.domain.user.domain;

import lombok.*;

public class UserCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterUserRequest {
        private final String name;
        private final Integer age;

        public User toEntity() {
            return User.builder()
                    .name(name)
                    .age(age)
                    .build();
        }
    }
}
