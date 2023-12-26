package com.example.lab_session3_4.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class AccountCourseReqDTO {
    private Long accountId;
    private Long courseId;
    private Date registrationDate;
    private BigDecimal purchasePrice;
}
