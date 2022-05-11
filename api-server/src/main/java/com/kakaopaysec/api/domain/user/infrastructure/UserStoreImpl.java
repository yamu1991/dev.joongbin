package com.kakaopaysec.api.domain.user.infrastructure;

import com.kakaopaysec.api.domain.user.domain.User;
import com.kakaopaysec.api.domain.user.domain.UserStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserStoreImpl implements UserStore {

    private final UserRepository userRepository;

    @Override
    // user 저장을 위한 함수
    public User store(User initUser) {
        return userRepository.save(initUser);
    }
}
