package com.example.accountmanagement.service.v2;

import com.example.accountmanagement.dto.AccountDto;
import com.example.accountmanagement.dto.BaseResponseDto;

import java.util.List;

public interface AccountService {
    BaseResponseDto<List<AccountDto>> getAll();
}
