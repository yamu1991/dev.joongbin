package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.account.domain.history.AccountHistory;
import com.kakaopaysec.api.domain.user.domain.User;
import com.kakaopaysec.api.global.util.BooleanStaticConverter;
import lombok.Builder;
import lombok.Getter;

public class AccountCommand {

    @Getter
    @Builder
    public static class RegisterAccountRequest {
        private final Long userId;

        public Account toEntity(User user) {
            return Account.builder()
                    .user(user)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class RegisterAccountHistoryRequest {
        private final Long accountId;
        private final String isDeposit;
        private final Long price;

        public AccountHistory toEntity(Account account) {
            return AccountHistory.builder()
                    .account(account)
                    .isDeposit(BooleanStaticConverter.convertStringToBoolean(isDeposit))
                    .price(price)
                    .build();
        }
    }
}
