package com.kakaopaysec.api.domain.user.interfaces;

import com.kakaopaysec.api.domain.user.application.UserFacade;
import com.kakaopaysec.api.domain.user.interfaces.dto.UserDto;
import com.kakaopaysec.api.global.response.http.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    // 유저 추가 API
    @PostMapping
    public CommonResponse registerUser(
            @RequestBody @Valid UserDto.RegisterUserRequest request
    ) {
        var userId = userFacade.registerUser(request.toCommand());
        var response = new UserDto.RegisterUserResponse(userId);
        return CommonResponse.success(response, "유저 추가 완료");
    }

    // 유저 리스트 조회 API
    @GetMapping("list")
    public CommonResponse getUserList() {
        var userList = userFacade.getUserList();
        var response = UserDto.Main.of(userList);
        return CommonResponse.success(response, "유저 목록 조회 성공");
    }
}
