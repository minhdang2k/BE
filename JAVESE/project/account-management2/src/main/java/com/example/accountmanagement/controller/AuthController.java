package com.example.accountmanagement.controller;

import com.example.accountmanagement.dto.AccountDto;
import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.dto.LoginResponseDto;
import com.example.accountmanagement.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponseDto<Void>> register(@RequestBody AccountDto account) {
        return ResponseEntity.ok(accountService.create(account));
    }

    @PostMapping("/authentication")
    public ResponseEntity<BaseResponseDto<LoginResponseDto>> login(@RequestBody @Valid AccountDto account) {
        return ResponseEntity.ok(accountService.login(account));
    }
}
