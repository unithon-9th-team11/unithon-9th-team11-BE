package com.gitjupalza.member.repository;

import com.gitjupalza.member.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Long> {
    Account save(Account account);
    Optional<Account> findById(String id);
}