package com.example.accountmanagement.repository;

import com.example.accountmanagement.entity.Account;

import java.util.List;

public interface AccountDao extends Dao<Account> {
    List<Account> findAll();

    Account findById(Long id);

    void insert(Account account);
}
