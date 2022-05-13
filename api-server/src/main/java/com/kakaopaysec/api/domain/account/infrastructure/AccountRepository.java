package com.kakaopaysec.api.domain.account.infrastructure;

import com.kakaopaysec.api.domain.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}