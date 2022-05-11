package com.kakaopaysec.api.domain.account.domain;

import java.util.List;

public interface AccountService {

    String registerAccount(AccountCommand.RegisterAccountRequest request);

    List<AccountInfo.Main> getAccountList();
}
