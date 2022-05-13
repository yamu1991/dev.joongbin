package com.kakaopaysec.api.domain.account.infrastructure;

import com.kakaopaysec.api.domain.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountById(Long id);

    @Query("SELECT distinct a from tbl_account a LEFT JOIN a.accountHistoryList WHERE a.userId = :userId")
    List<Account> findAccountByUserIdWithHistory(Long userId);
}