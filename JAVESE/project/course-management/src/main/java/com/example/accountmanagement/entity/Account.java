package com.example.accountmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "accountjdbc")
@Table(name = "accountjdbc")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "username")
    private String username;
    @Column(name= "password")
    private String password;
    @Column(name= "firstname")
    private String firstName;
    @Column(name= "lastname")
    private String lastName;
    @Column(name= "email")
    private String email;
    @Column(name= "status")
    private boolean status;
    @Column(name= "create_date")
    private Date createDate;
}
