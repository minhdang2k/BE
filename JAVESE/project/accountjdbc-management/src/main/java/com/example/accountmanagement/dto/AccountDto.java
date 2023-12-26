package com.example.accountmanagement.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountDto {
    private Long id;
    private String username;
    private boolean status;
    private String createDate;// format dd-mm-yyyy
    private UserDto user;
    private List<AccountCourseDto> accountCourses;
}
