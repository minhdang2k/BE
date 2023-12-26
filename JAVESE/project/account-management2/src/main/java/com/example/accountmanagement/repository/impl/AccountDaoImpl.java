package com.example.accountmanagement.repository.impl;

import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.mapper.impl.AccountMapper;
import com.example.accountmanagement.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {
    @Autowired
    private AccountMapper accountMapper;


    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        return super.query(sql, accountMapper);
    }

    @Override
    public Account findById(Long id) {
        String sql = "select * from account where id = ?";
        return super.query(sql, accountMapper, id).stream().findAny().orElse(null);
    }

    @Override
    public void insert(Account account) {
        String sql = "insert into account(username, password, status, create_date)\n" +
                "values (?, ?, ?, ?)";

        // encrypt
        String passwordEncrypted = BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12));

        super.insert(sql, account.getUsername(), passwordEncrypted, account.isStatus(), account.getCreateDate());
    }


}
