package com.kakaopaysec.api.domain.user.domain;

public interface UserService {
    Long registerUser(UserCommand.RegisterUserRequest request);
}
