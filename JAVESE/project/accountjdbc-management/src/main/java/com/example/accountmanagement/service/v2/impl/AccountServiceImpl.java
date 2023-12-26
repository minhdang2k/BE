package com.example.accountmanagement.service.v2.impl;

import com.example.accountmanagement.dto.*;
import com.example.accountmanagement.entity.Account;
import com.example.accountmanagement.entity.AccountCourse;
import com.example.accountmanagement.entity.Course;
import com.example.accountmanagement.entity.User;
import com.example.accountmanagement.repository.AccountRepository;
import com.example.accountmanagement.service.v2.AccountService;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    @Override
    public BaseResponseDto<List<AccountDto>> getAll() {
        List<Account> accounts= accountRepository.findAll();
        List<AccountDto> accountDtos= new ArrayList<>();
        for (Account account: accounts){
            AccountDto dto= new AccountDto();
            dto.setId(account.getId());
            dto.setUsername(account.getUsername());
            dto.setStatus(account.isStatus());
            dto.setCreateDate(account.getCreateDate().toString());

            User user= account.getUser();
            UserDto userDto= new UserDto();
            userDto.setId(userDto.getId());
            userDto.setFirstname(userDto.getFirstname());
            userDto.setLastname(userDto.getLastname());
            userDto.setEmail(userDto.getEmail());
            dto.setUser(userDto);

            List<AccountCourseDto> accountCourses= account.getAccountCourses()
                    .stream()
                    .map(accountCourse -> {
                        AccountCourseDto accountCourseDto=new AccountCourseDto();
                        accountCourseDto.setId(accountCourseDto.getId());
                        accountCourseDto.setPurchasePrice(accountCourse.getPurchasePrice());
                        accountCourseDto.setRegistration(accountCourse.getRegistration());
                        Course course= accountCourse.getCourse();
                        CourseDto courseDto= new CourseDto();
                        courseDto.setId(course.getId());
                        courseDto.setName(course.getName());
                        courseDto.setStartDate(courseDto.getStartDate());
                        courseDto.setEndDate(courseDto.getEndDate());
                        courseDto.setDescription(courseDto.getDescription());
                        courseDto.setPrice(courseDto.getPrice());
                        accountCourseDto.setCourse(courseDto);
                        return accountCourseDto;
                    }).collect(Collectors.toList());
            dto.setAccountCourses(accountCourses);
            accountDtos.add(dto);
        }
        return BaseResponseDto.<List<AccountDto>>builder()
                .status("00")
                .message("success")
                .build();
    }
}
