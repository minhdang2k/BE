package com.example.accountmanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Long id;
    private String username;
    private String password;
    private boolean status;
    private Date createDate;
}
