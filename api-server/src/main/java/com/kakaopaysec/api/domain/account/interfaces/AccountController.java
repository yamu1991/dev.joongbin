package com.kakaopaysec.api.domain.account.interfaces;

import com.kakaopaysec.api.domain.account.application.AccountFacade;
import com.kakaopaysec.api.domain.account.interfaces.dto.AccountDto;
import com.kakaopaysec.api.global.response.http.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountFacade accountFacade;

    @GetMapping
    public CommonResponse getAccountList() {
        var accountList = accountFacade.getAccountList();
        var response = AccountDto.Main.of(accountList);
        return CommonResponse.success(response);
    }
}
