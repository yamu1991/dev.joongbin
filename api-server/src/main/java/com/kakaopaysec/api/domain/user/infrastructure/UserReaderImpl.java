package com.kakaopaysec.api.domain.user.infrastructure;

import com.kakaopaysec.api.domain.user.domain.User;
import com.kakaopaysec.api.domain.user.domain.UserReader;
import com.kakaopaysec.api.global.exception.errors.BaseException;
import com.kakaopaysec.api.global.exception.errors.ErrorCodes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

    private final UserRepository userRepository;

    @Override
    public User findUserById(Long userId) {
        return userRepository.findUserById(userId)
                .orElseThrow(() -> new BaseException(ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
