package com.kakaopaysec.api.domain.account.domain.history;

import com.kakaopaysec.api.domain.account.domain.Account;
import com.kakaopaysec.api.global.exception.errors.BadRequestException;
import com.kakaopaysec.api.global.util.BooleanConverter;
import lombok.*;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_account_history")
public class AccountHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "account_id", insertable = false, updatable = false)
    private Long accountId;

    @Column
    @Convert(converter = BooleanConverter.class)
    private Boolean isDeposit;

    @Column
    private Long price;

    @Column(columnDefinition = "DATE")
    private Date transactionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Builder
    public AccountHistory(Account account, boolean isDeposit, Long price) {
        if (ObjectUtils.isEmpty(isDeposit)) throw new BadRequestException("isDeposit는 필수값입니다");
        if (ObjectUtils.isEmpty(price)) throw new BadRequestException("price는 필수값입니다");

        this.account = account;
        this.isDeposit = isDeposit;
        this.price = price;
        this.transactionDate = new Date();
    }
}
