package com.kakaopaysec.api.domain.account.infrastructure.history;

import com.kakaopaysec.api.domain.account.domain.history.AccountHistory;
import com.kakaopaysec.api.domain.account.domain.history.AccountHistoryReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountHistoryReaderImpl implements AccountHistoryReader {

    private final AccountHistoryRepository accountHistoryRepository;

    @Override
    public List<AccountHistory> getAccountHistoryList() {
        return accountHistoryRepository.findAll();
    }
}
