package com.kakaopaysec.api.domain.account.domain;

import java.util.List;

public interface AccountService {

    List<AccountInfo.Main> getAccountList();
}
