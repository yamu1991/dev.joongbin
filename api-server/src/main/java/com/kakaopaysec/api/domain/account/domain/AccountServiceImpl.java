package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.account.domain.history.AccountHistoryReader;
import com.kakaopaysec.api.domain.account.domain.history.AccountHistoryStore;
import com.kakaopaysec.api.domain.user.domain.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
        var account = accountReader.getAccountList();

        return AccountInfo.Main.of(account);
    }

    @Override
    public Long registerAccountHistory(AccountCommand.RegisterAccountHistoryRequest request) {
        var account = accountReader.findAccountById(request.getAccountId());
        var accountHistory =
                accountHistoryStore.registerAccountHistory(request.toEntity(account));

        return accountHistory.getId();
    }

    @Override
    public List<AccountInfo.HistoryInfo> getAccountHistoryList() {
        var accountHistory = accountHistoryReader.getAccountHistoryList();

        return AccountInfo.HistoryInfo.of(accountHistory);
    }

    @Override
    public List<AccountInfo.MyAccountInfo> getMyAccountList(Long userId) {
        userReader.findUserById(userId);
        var accountList = accountReader.getAccountListByUserId(userId);
        List<AccountInfo.MyAccountInfo> myAccountInfoList = new ArrayList<>();

        accountList.forEach(account -> {
            // isDeposite??? true ?????? ????????? ????????? ???????????? false ?????? -???????????? ????????????
            Long balance = account.getAccountHistoryList().stream().map(it -> it.getIsDeposit() ? it.getPrice() : -it.getPrice()).mapToLong(Long::valueOf).sum();
            var myAccountInfo = AccountInfo.MyAccountInfo.builder()
                    .accountId(account.getId()).balance(balance).build();

            myAccountInfoList.add(myAccountInfo);
        });

        return myAccountInfoList;
    }
}
