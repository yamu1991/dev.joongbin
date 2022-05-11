package com.kakaopaysec.api.domain.account.domain;

import com.kakaopaysec.api.domain.user.domain.User;
import com.kakaopaysec.api.global.exception.errors.BadRequestException;
import lombok.*;
import org.springframework.util.ObjectUtils;

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
    public Account(String id, User user) {
        // Id같은 경우 추후 고려
//        if (!StringUtils.hasLength(id)) throw new BadRequestException("id는 필수값입니다");
        if (ObjectUtils.isEmpty(user)) throw new BadRequestException("userId는 필수값입니다");

        this.id = id;
        this.user = user;
    }

}
