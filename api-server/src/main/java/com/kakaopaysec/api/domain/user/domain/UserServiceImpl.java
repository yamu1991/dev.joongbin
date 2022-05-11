package com.kakaopaysec.api.domain.user.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStore userStore;

    @Override
    public Long registerUser(UserCommand.RegisterUserRequest request) {
        var user = userStore.store(request.toEntity());
        return user.getId();
    }
}
