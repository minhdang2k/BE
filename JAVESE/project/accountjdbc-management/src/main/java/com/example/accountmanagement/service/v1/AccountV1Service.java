package com.example.accountmanagement.service.v1;

import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.entity.Account;

import java.util.List;

public interface AccountV1Service {
    BaseResponseDto<List<Account>> getAll();

    BaseResponseDto<Account> getById(Long id);

    BaseResponseDto<Void> create(Account account);


    BaseResponseDto<Account> delete(Long id);
}
