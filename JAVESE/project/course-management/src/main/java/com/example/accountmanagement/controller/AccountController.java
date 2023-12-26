package com.example.accountmanagement.controller;

import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v2/accountjdbc")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<BaseResponseDto<List<Account>>> getAll(){
        BaseResponseDto<List<Account>> baseResponseDto= accountService.getAll();

        return ResponseEntity.ok(baseResponseDto);
    }

    @GetMapping("")
    public ResponseEntity<BaseResponseDto<Account>> getById(@RequestParam("id") Long id){
        BaseResponseDto<Account> baseResponseDto= accountService.getById(id);

        return ResponseEntity.ok(baseResponseDto);
    }
    @PostMapping()
    public ResponseEntity<BaseResponseDto<Void>> create(@RequestBody() Account account){
        BaseResponseDto<Void> baseResponseDto= accountService.create(account);

        return ResponseEntity.ok(baseResponseDto);
    }
}
