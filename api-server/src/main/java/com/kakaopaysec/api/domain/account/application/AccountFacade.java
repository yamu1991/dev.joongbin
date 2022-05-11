package com.kakaopaysec.api.domain.account.application;

import com.kakaopaysec.api.domain.account.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountFacade {

    private final AccountServiceImpl accountService;

    public String registerAccount(AccountCommand.RegisterAccountRequest request) {
        return accountService.registerAccount(request);
    }

    public List<AccountInfo.Main> getAccountList() {
        return accountService.getAccountList();
    }
}
