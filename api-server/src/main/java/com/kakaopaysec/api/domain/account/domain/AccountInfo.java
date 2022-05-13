package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.account.domain.history.AccountHistory;
import com.kakaopaysec.api.global.util.CustomMapper;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class AccountInfo {

    @Getter
    @Builder
    public static class Main {
        private Long accountId;
        private Long userId;

        public static List<Main> of(List<Account> accountList) {
            return CustomMapper.listMapper(accountList,
                    account -> Main.builder()
                            .accountId(account.getId())
                            .userId(account.getId())
                            .build());
        }
    }

    @Getter
    @Builder
    public static class HistoryInfo {
        private Long accountHistoryId;
        private Long accountId;
        private Boolean isDeposit;
        private Long price;
        private Date transactionDate;

        public static List<HistoryInfo> of(List<AccountHistory> accountHistoryList) {
            return CustomMapper.listMapper(accountHistoryList,
                    accountHistory -> HistoryInfo.builder()
                            .accountHistoryId(accountHistory.getId())
                            .accountId(accountHistory.getAccountId())
                            .isDeposit(accountHistory.getIsDeposit())
                            .price(accountHistory.getPrice())
                            .transactionDate(accountHistory.getTransactionDate())
                            .build());
        }
    }

    @Getter
    @Builder
    public static class MyAccountInfo {
        private Long accountId;
        private Long balance;
    }
}
