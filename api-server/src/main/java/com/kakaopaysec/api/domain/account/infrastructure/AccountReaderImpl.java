package com.kakaopaysec.api.domain.account.infrastructure;

import com.kakaopaysec.api.domain.account.domain.Account;
import com.kakaopaysec.api.domain.account.domain.AccountReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountReaderImpl implements AccountReader {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }
}
