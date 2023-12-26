package com.example.lab_session3_4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountReqDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
