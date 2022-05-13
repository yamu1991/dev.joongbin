package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.account.domain.history.AccountHistory;
import com.kakaopaysec.api.domain.user.domain.User;
import com.kakaopaysec.api.global.exception.errors.BadRequestException;
import lombok.*;
import org.springframework.util.ObjectUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "account")
    private List<AccountHistory> accountHistoryList = new ArrayList<>();

    @Builder
    public Account(Long id, User user) {
        if (ObjectUtils.isEmpty(id)) throw new BadRequestException("id는 필수값입니다");

        this.id = id;
        this.user = user;
    }

}
