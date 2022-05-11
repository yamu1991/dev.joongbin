package com.kakaopaysec.api.domain.user.interfaces.dto;

import com.kakaopaysec.api.domain.user.domain.UserCommand;
import com.kakaopaysec.api.domain.user.domain.UserInfo;
import lombok.*;

import java.util.*;

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

    @Getter
    @Builder
    @ToString
    public static class Main {
        private final Long id;
        private final String name;
        private final Integer age;
        private final Date joinDate;

        public static List<Main> of(List<UserInfo.Main> userList) {
            List<Main> mainList = new ArrayList<>();
            for (UserInfo.Main user : userList) {
                mainList.add(Main.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .age(user.getAge())
                        .joinDate(user.getJoinDate())
                        .build());
            }
            return mainList;
        }
    }
}
