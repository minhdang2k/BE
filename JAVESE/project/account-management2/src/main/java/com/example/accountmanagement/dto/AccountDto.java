package com.example.accountmanagement.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountDto {
    private Long id;
    @NotBlank
    private String username;

    @NotBlank
    private String password;
    private boolean status;
    private String createDate;// format dd-mm-yyyy
}
