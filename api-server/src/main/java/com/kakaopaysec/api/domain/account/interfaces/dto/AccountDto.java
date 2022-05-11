package com.kakaopaysec.api.domain.account.interfaces.dto;

import com.kakaopaysec.api.domain.account.domain.AccountCommand;
import com.kakaopaysec.api.domain.account.domain.AccountInfo;
import com.kakaopaysec.api.global.util.CustomMapper;
import lombok.*;

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
    @AllArgsConstructor
    public static class RegisterAccountResponse {
        private final String accountId;
    }

    @Getter
    @Builder
    @ToString
    public static class Main {
        private final String accountId;
        private final Long userId;

        public static List<Main> of(List<AccountInfo.Main> accountList) {
            return CustomMapper.listMapper(accountList,
                    account -> Main.builder()
                            .accountId(account.getAccountId())
                            .userId(account.getUserId())
                            .build());
        }
    }
}
