package com.kakaopaysec.api.domain.user.infrastructure;

import com.kakaopaysec.api.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}