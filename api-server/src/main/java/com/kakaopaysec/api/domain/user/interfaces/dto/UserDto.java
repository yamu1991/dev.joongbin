package com.kakaopaysec.api.domain.user.interfaces.dto;

import com.kakaopaysec.api.domain.user.domain.UserCommand;
import lombok.*;

public class UserDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterUserRequest {
        private String name;
        private Integer age;

        public UserCommand.RegisterUserRequest toCommand() {
            return UserCommand.RegisterUserRequest.builder()
                    .name(name)
                    .age(age)
                    .build();
        }
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public static class RegisterUserResponse {
        private Long userId;
    }
}
