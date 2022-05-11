package com.kakaopaysec.api.domain.user.infrastructure;

import com.kakaopaysec.api.domain.user.domain.User;
import com.kakaopaysec.api.domain.user.domain.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserReaderImpl implements UserReader {

    private final UserRepository userRepository;


    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
