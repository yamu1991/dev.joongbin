package com.kakaopaysec.api.domain.user.domain;

import com.kakaopaysec.api.domain.account.domain.Account;
import lombok.*;

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

    @Column
    private Date joinDate;

    @OneToMany(mappedBy = "user")
    private List<Account> accountList = new ArrayList<>();

    @Builder
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.joinDate = new Date();
    }
}
