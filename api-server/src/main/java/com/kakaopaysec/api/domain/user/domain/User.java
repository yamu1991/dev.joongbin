package com.kakaopaysec.api.domain.user.domain;

import com.kakaopaysec.api.domain.account.domain.Account;
import com.kakaopaysec.api.global.exception.errors.BadRequestException;
import lombok.*;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column(columnDefinition = "DATE")
    private Date joinDate;

    @OneToMany(mappedBy = "user")
    private List<Account> accountList = new ArrayList<>();

    @Builder
    public User(Long id, String name, Integer age) {
        if (!StringUtils.hasLength(name)) throw new BadRequestException("name은 필수값입니다");
        if (ObjectUtils.isEmpty(age)) throw new BadRequestException("age는 필수값입니다");

        this.name = name;
        this.age = age;
        this.joinDate = new Date();
    }
}
