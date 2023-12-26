package com.example.lab_session3_4.security;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Builder
@Setter
@Getter
public class JwtGenerated {
    private String accessToken;
    private Date expiredIn;
}
