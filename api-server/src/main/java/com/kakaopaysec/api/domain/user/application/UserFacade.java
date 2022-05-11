package com.kakaopaysec.api.domain.user.application;

import com.kakaopaysec.api.domain.user.domain.UserCommand;
import com.kakaopaysec.api.domain.user.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;

    public Long registerUser(UserCommand.RegisterUserRequest request) {
        return userService.registerUser(request);
    }
}
