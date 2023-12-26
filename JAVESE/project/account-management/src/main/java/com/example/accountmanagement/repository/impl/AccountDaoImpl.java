package com.example.accountmanagement.repository.impl;

import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.mapper.RowMapper;
import com.example.accountmanagement.mapper.impl.AccountMapper;
import com.example.accountmanagement.repository.AccountDao;
import com.example.accountmanagement.repository.impl.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class AccountDaoImpl extends BaseDao<Account>  implements AccountDao {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public List<Account> findAll() {
        String sql= "select * from account";
       return super.query(sql, accountMapper);
    }

    @Override
    public Account findById(Long id) {
        String sql= "select * from account where id=?";
      return super.query(sql, accountMapper, id).stream().findAny().orElse(null);
    }

    @Override
    public void insert(Account account) {
        String sql="insert into account(username, password, status, create_date) \n" +
                "values (?,?,?,?) ";
        super.insert(sql, account.getUsername(), account.getPassword(), account.isStatus(), account.getCreateDate());
    }
}
