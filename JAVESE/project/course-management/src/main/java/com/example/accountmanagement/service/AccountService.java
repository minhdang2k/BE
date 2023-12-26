package com.example.accountmanagement.service;

import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.entity.Account;

import java.util.List;

public interface AccountService {
    BaseResponseDto<List<Account>> getAll();

    BaseResponseDto<Account> getById(Long id);

    BaseResponseDto<Void> create(Account account);


    BaseResponseDto<Account> delete(Long id);
}
