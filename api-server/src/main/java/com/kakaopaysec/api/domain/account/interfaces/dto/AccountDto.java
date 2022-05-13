package com.kakaopaysec.api.domain.account.interfaces.dto;

import com.kakaopaysec.api.domain.account.domain.AccountCommand;
import com.kakaopaysec.api.domain.account.domain.AccountInfo;
import com.kakaopaysec.api.global.util.BooleanStaticConverter;
import com.kakaopaysec.api.global.util.CustomMapper;
import lombok.*;

import java.util.Date;
import java.util.List;

public class AccountDto {

    @Getter
    @Setter
    public static class RegisterAccountRequest {
        private Long userId;

        public AccountCommand.RegisterAccountRequest toCommand() {
            return AccountCommand.RegisterAccountRequest.builder()
                    .userId(userId)
                    .build();
        }
    }

    @Getter
    @Setter
    public static class RegisterAccountHistoryRequest {
        private Long accountId;
        private String isDeposit;
        private Long price;

        public AccountCommand.RegisterAccountHistoryRequest toCommand() {
            return AccountCommand.RegisterAccountHistoryRequest.builder()
                    .accountId(accountId)
                    .isDeposit(isDeposit)
                    .price(price)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class RegisterAccountResponse {
        private final Long accountId;
    }

    @Getter
    @AllArgsConstructor
    public static class RegisterAccountHistoryResponse {
        private final Long accountHistoryId;
    }

    @Getter
    @Builder
    @ToString
    public static class Main {
        private final Long accountId;
        private final Long userId;

        public static List<Main> of(List<AccountInfo.Main> accountList) {
            return CustomMapper.listMapper(accountList,
                    account -> Main.builder()
                            .accountId(account.getAccountId())
                            .userId(account.getUserId())
                            .build());
        }
    }

    @Getter
    @Builder
    public static class AccountHistoryResponse {
        private Long accountHistoryId;
        private Long accountId;
        private String isDeposit;
        private Long price;
        private Date transactionDate;

        public static List<AccountHistoryResponse> of(List<AccountInfo.HistoryInfo> accountHistoryList) {
            return CustomMapper.listMapper(accountHistoryList,
                    accountHistory -> AccountHistoryResponse.builder()
                            .accountHistoryId(accountHistory.getAccountHistoryId())
                            .accountId(accountHistory.getAccountId())
                            .isDeposit(BooleanStaticConverter.convertBooleanToString(accountHistory.getIsDeposit()))
                            .price(accountHistory.getPrice())
                            .transactionDate(accountHistory.getTransactionDate())
                            .build());
        }
    }

}
