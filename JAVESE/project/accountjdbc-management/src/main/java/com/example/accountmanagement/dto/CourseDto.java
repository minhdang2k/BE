package com.example.accountmanagement.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CourseDto {
    private Long id;

    private String name;

    private String description;

    private Date startDate;

    private Date endDate;

    private BigDecimal price;
}
