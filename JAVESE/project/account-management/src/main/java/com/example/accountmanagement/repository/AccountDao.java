package com.example.accountmanagement.repository;

import com.example.accountmanagement.entity.Account;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AccountDao extends Dao<Account>{
    List<Account> findAll();
    Account findById(Long id);
    void insert(Account account);
}
