package com.example.accountmanagement.controller;

import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController // controller + responseBody
@RequestMapping("/api/v1/account")
public class AccountController {

    // Service
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<BaseResponseDto<List<Account>>> getAll() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @GetMapping()
    public ResponseEntity<BaseResponseDto<Account>> getById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<BaseResponseDto<Void>> create(@RequestBody() Account account) {
        return ResponseEntity.ok(accountService.create(account));
    }
    @PostMapping()
    public ResponseEntity<BaseResponseDto<Void>> update(@RequestParam("id") Long id, @RequestBody() Account account){
        return ResponseEntity.ok(accountService.update(id, account));
    }
    @PutMapping()
    public ResponseEntity<BaseResponseDto<Void>> delete(@RequestParam("id") Long id){
        return ResponseEntity.ok(accountService.delete(id));
    }
}
