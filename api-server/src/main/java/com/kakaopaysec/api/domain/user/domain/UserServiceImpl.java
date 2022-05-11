package com.kakaopaysec.api.domain.user.domain;

import com.kakaopaysec.api.domain.user.domain.UserCommand.RegisterUserRequest;
import com.kakaopaysec.api.domain.user.domain.UserInfo.Main;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserStore userStore;
    private final UserReader userReader;

    // 사용자 추가
    @Override
    @Transactional
    public Long registerUser(RegisterUserRequest request) {
        var user = userStore.store(request.toEntity());
        return user.getId();
    }

    // 사용자 목록
    @Override
    @Transactional(readOnly = true)
    public List<Main> getUserList() {
        var userList = userReader.getUserList();
        return Main.of(userList);
    }
}
