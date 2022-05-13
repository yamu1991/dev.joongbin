package com.kakaopaysec.api.domain.account.infrastructure.history;

import com.kakaopaysec.api.domain.account.domain.history.AccountHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Long> {
}