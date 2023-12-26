package com.example.lab_session3_4.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO<T> {
    private HttpStatus status;
    private String message;
    private T data;
}
