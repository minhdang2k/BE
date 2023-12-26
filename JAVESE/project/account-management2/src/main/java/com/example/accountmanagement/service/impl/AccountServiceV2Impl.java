package com.example.accountmanagement.service.impl;

import com.example.accountmanagement.constant.AppConstant;
import com.example.accountmanagement.constant.Role;
import com.example.accountmanagement.dto.AccountDto;
import com.example.accountmanagement.dto.BaseResponseDto;
import com.example.accountmanagement.dto.LoginResponseDto;
import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.entity.RoleEntity;
import com.example.accountmanagement.exception.AccountException;
import com.example.accountmanagement.repository.AccountRepository;
import com.example.accountmanagement.repository.RoleRepository;
import com.example.accountmanagement.security.CustomUserDetails;
import com.example.accountmanagement.security.JwtGenerated;
import com.example.accountmanagement.security.JwtTokenUtil;
import com.example.accountmanagement.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class AccountServiceV2Impl implements AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public BaseResponseDto<List<Account>> getAll() {
        BaseResponseDto<List<Account>> responseDto = new BaseResponseDto<>();

        try {
            List<Account> list = accountRepository.findAll();

            responseDto.setStatus("00");
            responseDto.setData(list);
            responseDto.setMessage("Success");

        } catch (AccountException e) {
            responseDto.setStatus("99");
            responseDto.setData(null);
            responseDto.setMessage(e.getMessage());
        }

        return responseDto;
    }

    @Override
    public BaseResponseDto<Account> getById(Long id) {
        BaseResponseDto<Account> responseDto = new BaseResponseDto<>();

        try {
            Account account = accountRepository.findById(id).orElse(null);

            responseDto.setStatus("00");
            responseDto.setData(account);
            responseDto.setMessage("Success");

        } catch (AccountException e) {
            responseDto.setStatus("99");
            responseDto.setData(null);
            responseDto.setMessage(e.getMessage());
        }

        return responseDto;
    }

    @Override
    public BaseResponseDto<Void> create(Account account) {
        // call dao insert
        accountRepository.save(account);

        BaseResponseDto<Void> responseDto = new BaseResponseDto<>();
        responseDto.setStatus("00");
        responseDto.setMessage("Success");
        return responseDto;
    }

    @Override
    public BaseResponseDto<Void> create(AccountDto accountDto) {
        // get roles
        RoleEntity roleEntity = roleRepository.findByName(Role.USER.name()).orElseThrow();

        Account account = new Account();
        account.setUsername(accountDto.getUsername());
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        account.setCreateDate(new Date());
        account.setStatus(true);
        account.setRoles(Set.of(roleEntity));

        accountRepository.save(account);

        BaseResponseDto<Void> responseDto = new BaseResponseDto<>();
        responseDto.setStatus("00");
        responseDto.setMessage("Success");
        return responseDto;
    }

    @Override
    public BaseResponseDto<LoginResponseDto> login(AccountDto account) {
        var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));
        if (authentication.isAuthenticated()) {
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            JwtGenerated jwtGenerated = jwtTokenUtil.generateToken(userDetails);

            return BaseResponseDto.<LoginResponseDto>builder()
                    .status(AppConstant.SUCCESS_STATUS)
                    .message(AppConstant.SUCCESS_MESSAGE)
                    .data(
                            LoginResponseDto.builder()
                                    .accessToken(jwtGenerated.getAccessToken())
                                    .expiredIn(jwtGenerated.getExpiredIn())
                                    .roles(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                                    .build()
                    )
                    .build();
        } else {
            throw new UsernameNotFoundException("Not found username = " + account.getUsername());
        }
    }

    @Override
    public BaseResponseDto<Void> delete(Long id) {
         accountRepository.deleteById(id);

        BaseResponseDto<Void> responseDto = new BaseResponseDto<>();
        responseDto.setStatus("00");
        responseDto.setMessage("Success");
        return responseDto;
    }

    @Override
    public BaseResponseDto<Account> update(Long id, Account updatedAccount) {
        if (accountRepository.existsById(id)) {
            updatedAccount.setId(id);
            return accountRepository.save(updatedAccount);
        }
        return null; // or throw an exception
    }
}

