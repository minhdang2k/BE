package com.example.accountmanagement.mapper;

import com.example.accountmanagement.dto.AccountDto;
import com.example.accountmanagement.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperV2 {

    public AccountDto toDto(Account account) {
        AccountDto dto = new AccountDto();
        dto.setId(account.getId());
        dto.setUsername(account.getUsername());
        dto.setPassword(account.getPassword());
        dto.setStatus(account.isStatus());
        dto.setCreateDate(account.getCreateDate().toString());

        return dto;
    }
}
