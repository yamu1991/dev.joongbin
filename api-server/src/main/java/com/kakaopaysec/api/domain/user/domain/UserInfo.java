package com.kakaopaysec.api.domain.user.domain;

import lombok.*;

import java.util.*;

public class UserInfo {

    @Getter
    @Builder
    @ToString
    // response
    public static class Main {
        private final Long id;
        private final String name;
        private final Integer age;
        private final Date joinData;

        public static List<Main> of(List<User> userList) {
            List<Main> mainList = new ArrayList<>();
            for (User user : userList) {
                mainList.add(Main.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .age(user.getAge())
                        .joinData(user.getJoinDate())
                        .build());
            }
            return mainList;
        }
    }
}
