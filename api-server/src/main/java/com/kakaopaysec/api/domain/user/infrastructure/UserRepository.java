package com.kakaopaysec.api.domain.user.infrastructure;

import com.kakaopaysec.api.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserById(Long id);
}