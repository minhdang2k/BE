package com.example.accountmanagement.service.v1.impl;

import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.exception.AccountException;
import com.example.accountmanagement.repository.AccountRepository;
import com.example.accountmanagement.service.v1.AccountV1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class AccountServiceV2Impl implements AccountV1Service {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public BaseResponseDto<List<Account>> getAll() {
        BaseResponseDto<List<Account>> responseDto = new BaseResponseDto<>();
        try {
            List<Account> list = accountRepository.findAll();
            responseDto.setStatus("00");
            responseDto.setData(list);
            responseDto.setMessage("success");

        } catch (AccountException e) {
            responseDto.setStatus("99");
            responseDto.setData(null);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public BaseResponseDto<Account> getById(Long id) {
        BaseResponseDto<Account> responseDto= new BaseResponseDto<>();
        try {
           Account account= accountRepository.findById(id).orElse(null);
            responseDto.setStatus("00");
            responseDto.setData(account);
            responseDto.setMessage("success");

        }catch (AccountException e){
            responseDto.setStatus("99");
            responseDto.setData(null);
            responseDto.setMessage(e.getMessage());
        }
        return responseDto;
    }

    @Override
    public BaseResponseDto<Void> create(Account account) {
        accountRepository.save(account);
        BaseResponseDto<Void> responseDto= new BaseResponseDto<>();
        responseDto.setStatus("00");
        responseDto.setData(null);
        responseDto.setMessage("success");
        return responseDto;
    }


    @Override
    public BaseResponseDto<Account> delete(Long id) {
        accountRepository.deleteById(id);
        BaseResponseDto<Account> responseDto= new BaseResponseDto<>();
        responseDto.setStatus("00");
        responseDto.setData(null);
        responseDto.setMessage("success");
        return responseDto;
    }
}
