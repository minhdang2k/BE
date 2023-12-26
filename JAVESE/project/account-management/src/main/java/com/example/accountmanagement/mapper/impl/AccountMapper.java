package com.example.accountmanagement.mapper.impl;

import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.mapper.RowMapper;
import org.springframework.stereotype.Component;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
@Component
public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs) throws SQLException {
            Long id= rs.getLong("id");
            String username= rs.getString("username");
            String password= rs.getString("password");
            boolean status= rs.getBoolean("status");
            Date createDate= rs.getDate("create_date");
            return new Account(id, username, password, status, createDate);
    }
}
