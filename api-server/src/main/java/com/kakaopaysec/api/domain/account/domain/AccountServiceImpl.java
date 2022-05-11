package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.user.domain.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserReader userReader;
    private final AccountReader accountReader;
    private final AccountStore accountStore;

    @Override
    public String registerAccount(AccountCommand.RegisterAccountRequest request) {
        userReader.findUserById(request.getUserId());
        
        var account = accountStore.registerAccount(request.toEntity());
        return account.getId();
    }

    @Override
    public List<AccountInfo.Main> getAccountList() {
        return AccountInfo.Main.of(accountReader.getAccountList());
    }
}
