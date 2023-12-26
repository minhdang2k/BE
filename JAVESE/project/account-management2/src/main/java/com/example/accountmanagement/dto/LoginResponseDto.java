package com.example.accountmanagement.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class LoginResponseDto {
    private String refreshToken;
    private String accessToken;
    private Date expiredIn;
    private List<String> roles;
}
