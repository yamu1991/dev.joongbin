package com.kakaopaysec.api.domain.account.application;

import com.kakaopaysec.api.domain.account.domain.AccountInfo;
import com.kakaopaysec.api.domain.account.domain.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountFacade {

    private final AccountServiceImpl accountService;

    public List<AccountInfo.Main> getAccountList() {
        return accountService.getAccountList();
    }
}
