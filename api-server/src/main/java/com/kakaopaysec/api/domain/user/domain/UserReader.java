package com.kakaopaysec.api.domain.user.domain;

import java.util.List;

public interface UserReader {

    User findUserById(Long userId);

    List<User> getUserList();
}
