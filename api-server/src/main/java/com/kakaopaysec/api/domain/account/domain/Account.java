package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_account")
public class Account {

    @Id
    @Column
    private String id;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Account(String id, Long userId, User user) {
        this.id = id;
        this.userId = userId;
        this.user = user;
    }

}
