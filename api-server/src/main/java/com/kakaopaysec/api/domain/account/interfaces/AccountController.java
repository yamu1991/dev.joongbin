package com.kakaopaysec.api.domain.account.interfaces;

import com.kakaopaysec.api.domain.account.application.AccountFacade;
import com.kakaopaysec.api.domain.account.interfaces.dto.AccountDto;
import com.kakaopaysec.api.global.response.http.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountFacade accountFacade;

    @PostMapping
    public CommonResponse registerAccount(
            @RequestBody @Valid AccountDto.RegisterAccountRequest request
    ) {
        var accountId = accountFacade.registerAccount(request.toCommand());
        var response = new AccountDto.RegisterAccountResponse(accountId);
        return CommonResponse.success(response);
    }

    @GetMapping("list")
    public CommonResponse getAccountList() {
        var accountList = accountFacade.getAccountList();
        var response = AccountDto.Main.of(accountList);
        return CommonResponse.success(response);
    }

    @PostMapping("history")
    public CommonResponse registerAccountHisotry(
            @RequestBody @Valid AccountDto.RegisterAccountHistoryRequest request
    ) {
        var accountHistoryId = accountFacade.registerAccountHistory(request.toCommand());
        var response = new AccountDto.RegisterAccountHistoryResponse(accountHistoryId);
        return CommonResponse.success(response);
    }
}
