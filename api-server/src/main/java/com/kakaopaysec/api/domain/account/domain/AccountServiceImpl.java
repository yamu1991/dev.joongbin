package com.kakaopaysec.api.domain.account.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountReader accountReader;
    private final AccountStore accountStore;

    @Override
    public List<AccountInfo.Main> getAccountList() {
        return AccountInfo.Main.of(accountReader.getAccountList());
    }
}
