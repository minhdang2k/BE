package com.example.lab_session3_4.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "account_course")
public class AccountCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date")
    private Date regisDate;

    @Column(name = "purchase_price")
    private BigDecimal purchase;

    @ManyToOne()
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;
}
