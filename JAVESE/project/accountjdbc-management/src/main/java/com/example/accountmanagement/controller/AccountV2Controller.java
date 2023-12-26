package com.example.accountmanagement.controller;

import com.example.accountmanagement.dto.AccountDto;
import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.service.v2.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/course_account")
public class AccountV2Controller {
    private  AccountService accountService;
    @GetMapping("list")
    public ResponseEntity<BaseResponseDto<AccountDto>> getAll(){
        return ResponseEntity.ok(accountService.getAll());
    }
}
