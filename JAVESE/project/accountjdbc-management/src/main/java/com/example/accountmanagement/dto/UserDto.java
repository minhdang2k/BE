package com.example.accountmanagement.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    private String firstname;

    private String lastname;

    private String email;
}
