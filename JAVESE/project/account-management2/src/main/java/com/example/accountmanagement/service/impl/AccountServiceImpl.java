//package com.example.accountmanagement.service.impl;
//
//import com.example.accountmanagement.dto.BaseResponseDto;
//import com.example.accountmanagement.entity.Account;
//import com.example.accountmanagement.exception.AccountException;
//import com.example.accountmanagement.repository.AccountDao;
//import com.example.accountmanagement.repository.AccountRepository;
//import com.example.accountmanagement.service.AccountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCrypt;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AccountServiceImpl implements AccountService {
//    // get from database => inject repo
//    @Autowired
//    private AccountDao accountDao;
//
//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Override
//    public BaseResponseDto<List<Account>> getAll() {
//        BaseResponseDto<List<Account>> responseDto = new BaseResponseDto<>();
//
//        try {
//            List<Account> list = accountRepository.findAll();
//
//            responseDto.setStatus("00");
//            responseDto.setData(list);
//            responseDto.setMessage("Success");
//
//        } catch (AccountException e) {
//            responseDto.setStatus("99");
//            responseDto.setData(null);
//            responseDto.setMessage(e.getMessage());
//        }
//
//        return responseDto;
//    }
//
//    @Override
//    public BaseResponseDto<Account> getById(Long id) {
//        BaseResponseDto<Account> responseDto = new BaseResponseDto<>();
//
//        try {
//            Account account = accountRepository.findById(id).orElseThrow();
//
//            responseDto.setStatus("00");
//            responseDto.setData(account);
//            responseDto.setMessage("Success");
//
//        } catch (AccountException e) {
//            responseDto.setStatus("99");
//            responseDto.setData(null);
//            responseDto.setMessage(e.getMessage());
//        }
//
//        return responseDto;
//    }
//
//    @Override
//    public BaseResponseDto<Void> create(Account account) {
//        // call dao insert
//        account.setPassword(BCrypt.hashpw(account.getPassword(), BCrypt.gensalt(12)));
//        accountRepository.save(account);
//
//        BaseResponseDto<Void> responseDto = new BaseResponseDto<>();
//        responseDto.setStatus("00");
//        responseDto.setMessage("Success");
//        return responseDto;
//    }
//}
