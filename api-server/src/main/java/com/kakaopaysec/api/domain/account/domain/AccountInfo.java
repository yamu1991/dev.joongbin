package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.global.util.CustomMapper;
import lombok.Builder;
import lombok.Getter;

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
                            .userId(account.getUser().getId())
                            .build());
        }
    }
}
