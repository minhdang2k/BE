package com.example.accountmanagement.service;

import com.example.accountmanagement.dto.AccountDto;
import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.dto.LoginResponseDto;
import com.example.accountmanagement.entity.Account;

import java.util.List;

public interface AccountService {
    BaseResponseDto<List<Account>> getAll();
    BaseResponseDto<Account> getById(Long id);

    BaseResponseDto<Void> create(Account account);
    BaseResponseDto<Void> create(AccountDto account);

    BaseResponseDto<LoginResponseDto> login(AccountDto account);
    BaseResponseDto<Account> update(Long id, Account updatedAccount);
    BaseResponseDto<Void> delete(Long id);
}
