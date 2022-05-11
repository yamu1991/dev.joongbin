package com.kakaopaysec.api.domain.account.infrastructure;

import com.kakaopaysec.api.domain.account.domain.Account;
import com.kakaopaysec.api.domain.account.domain.AccountStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountStoreImpl implements AccountStore {

    private final AccountRepository accountRepository;

    @Override
    public Account registerAccount(Account account) {
        return accountRepository.save(account);
    }
}
