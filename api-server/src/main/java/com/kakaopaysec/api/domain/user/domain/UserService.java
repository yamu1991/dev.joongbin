package com.kakaopaysec.api.domain.user.domain;

import java.util.List;

public interface UserService {

    Long registerUser(UserCommand.RegisterUserRequest request);

    List<UserInfo.Main> getUserList();
}
