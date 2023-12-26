package com.example.accountmanagement.service.impl;

import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.exception.AccountException;
import com.example.accountmanagement.repository.AccountDao;
import com.example.accountmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public BaseResponseDto<List<Account>> getAll() {
        BaseResponseDto<List<Account>> responseDto = new BaseResponseDto<>();
        try {
            List<Account> list = accountDao.findAll();
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
            Account account= accountDao.findById(id);
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
        accountDao.insert(account);
        BaseResponseDto<Void> responseDto= new BaseResponseDto<>();
        responseDto.setStatus("00");
        responseDto.setData(null);
        responseDto.setMessage("success");
        return responseDto;
    }



    @Override
    public BaseResponseDto<Account> delete(Long id) {
        return null;
    }
}

