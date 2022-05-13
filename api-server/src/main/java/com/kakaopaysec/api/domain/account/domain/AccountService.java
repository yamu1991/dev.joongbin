package com.kakaopaysec.api.domain.account.domain;

import java.util.List;

public interface
AccountService {

    Long registerAccount(AccountCommand.RegisterAccountRequest request);

    List<AccountInfo.Main> getAccountList();

    Long registerAccountHistory(AccountCommand.RegisterAccountHistoryRequest request);

    List<AccountInfo.HistoryInfo> getAccountHistoryList();
}
