package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.account.domain.history.AccountHistoryReader;
import com.kakaopaysec.api.domain.account.domain.history.AccountHistoryStore;
import com.kakaopaysec.api.domain.user.domain.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserReader userReader;
    private final AccountReader accountReader;
    private final AccountStore accountStore;
    private final AccountHistoryReader accountHistoryReader;
    private final AccountHistoryStore accountHistoryStore;

    @Override
    @Transactional
    public Long registerAccount(AccountCommand.RegisterAccountRequest request) {
        var user = userReader.findUserById(request.getUserId());
        var account = accountStore.registerAccount(request.toEntity(user));

        return account.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AccountInfo.Main> getAccountList() {
        return AccountInfo.Main.of(accountReader.getAccountList());
    }

    @Override
    public Long registerAccountHistory(AccountCommand.RegisterAccountHistoryRequest request) {
        var account = accountReader.findAccountById(request.getAccountId());
        var accountHistory =
                accountHistoryStore.registerAccountHistory(request.toEntity(account));

        return accountHistory.getAccountId();
    }

    @Override
    public List<AccountInfo.HistoryInfo> getAccountHisotryList() {
        return null;
    }
}
