package com.kakaopaysec.api.domain.user.domain;

import lombok.*;

import java.util.*;

public class UserInfo {

    @Getter
    @Builder
    @ToString
    // application으로 return하기 위한 객체
    public static class Main {
        private final Long id;
        private final String name;
        private final Integer age;
        private final Date joinDate;

        public static List<Main> of(List<User> userList) {
            List<Main> mainList = new ArrayList<>();
            for (User user : userList) {
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
