package com.example.accountmanagement.repository;

import com.example.accountmanagement.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //cú pháp viết method trong spring data jpa
    Optional<Account> findById(Long id);

}
