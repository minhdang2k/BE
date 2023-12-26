package com.example.lab_session3_4.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CourseDTO {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private String categoryName;
}
