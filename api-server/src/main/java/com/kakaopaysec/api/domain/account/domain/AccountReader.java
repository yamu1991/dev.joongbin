package com.kakaopaysec.api.domain.account.domain;

import java.util.List;

public interface AccountReader {

    Account findAccountById(Long accountId);

    List<Account> getAccountList();
}
