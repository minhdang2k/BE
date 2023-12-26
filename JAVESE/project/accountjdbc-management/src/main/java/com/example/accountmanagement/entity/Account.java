package com.example.accountmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "username", length = 255)
    private String username;
    @Column(name= "password", length = 255)
    private String password;
//    @Column(name= "firstname")
//    private String firstName;
//    @Column(name= "lastname")
//    private String lastName;
//    @Column(name= "email")
//    private String email;
    @Column(name= "status")
    private boolean status;
    @Column(name= "create_date")
    private Date createDate;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "account")
    private List<AccountCourse> accountCourses;
}
