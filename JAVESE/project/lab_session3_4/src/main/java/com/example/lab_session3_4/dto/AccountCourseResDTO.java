package com.example.lab_session3_4.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AccountCourseResDTO {
    private UserAccountResDTO accountDTO;
    private CourseDTO courseDTO;
    private Date registrationDate;
    private BigDecimal purchasePrice;
}
