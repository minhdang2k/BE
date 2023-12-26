package com.example.lab_session3_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class LabSession34Application {

    public static void main(String[] args) {
        SpringApplication.run(LabSession34Application.class, args);
    }

}
