package com.kakaopaysec.api.domain.account.infrastructure;

import com.kakaopaysec.api.domain.account.domain.Account;
import com.kakaopaysec.api.domain.account.domain.AccountReader;
import com.kakaopaysec.api.global.exception.errors.BaseException;
import com.kakaopaysec.api.global.exception.errors.ErrorCodes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountReaderImpl implements AccountReader {

    private final AccountRepository accountRepository;

    @Override
    public Account findAccountById(Long accountId) {
        return accountRepository.findAccountById(accountId)
                .orElseThrow(() -> new BaseException(ErrorCodes.ACCOUNT_NOT_FOUND));
    }

    @Override
    public List<Account> getAccountList() {
        return accountRepository.findAll();
    }

    @Override
    public List<Account> getAccountListByUserId(Long userId) {
        return accountRepository.findAccountByUserIdWithHistory(userId);
    }
}
