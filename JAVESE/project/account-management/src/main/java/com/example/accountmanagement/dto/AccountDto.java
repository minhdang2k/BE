package com.example.accountmanagement.dto;

import lombok.Data;

@Data
public class AccountDto {
    private Long id;
    private String username;
    private boolean status;
    private String createDate;// format dd-mm-yyyy
}
