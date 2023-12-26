package com.example.accountmanagement.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class AccountCourseDto {
    private Long id;

    private Date registration;

    private BigDecimal purchasePrice;
    private CourseDto course;
}
