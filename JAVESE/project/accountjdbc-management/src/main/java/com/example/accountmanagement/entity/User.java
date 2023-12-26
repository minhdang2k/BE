package com.example.accountmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length = 50)
    private String firstname;
    @Column(name = "last_name", length = 50)
    private String lastname;
    @Column(name = "email", length = 100)
    private String email;
    @OneToOne(mappedBy = "user")
    private Account account;
    @ManyToMany(mappedBy = "users")
    private List<Role> roles;
}
