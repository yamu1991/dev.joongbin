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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
