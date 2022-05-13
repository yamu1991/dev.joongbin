package com.kakaopaysec.api.domain.account.infrastructure.history;

import com.kakaopaysec.api.domain.account.domain.history.AccountHistory;
import com.kakaopaysec.api.domain.account.domain.history.AccountHistoryStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountHistoryStoreImpl implements AccountHistoryStore {

    private final AccountHistoryRepository accountHistoryRepository;

    @Override
    public AccountHistory registerAccount(AccountHistory accountHistory) {
        return accountHistoryRepository.save(accountHistory);
    }
}
