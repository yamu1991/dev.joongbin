package com.kakaopaysec.api.domain.user.application;

import com.kakaopaysec.api.domain.user.domain.UserCommand;
import com.kakaopaysec.api.domain.user.domain.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
// 다른 시스템의 application 계층과 상호작용하기 위하여 사용합니다
public class UserFacade {
    private final UserService userService;

    public Long registerUser(UserCommand.RegisterUserRequest request) {
        return userService.registerUser(request);
    }
}
