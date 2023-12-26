package com.example.accountmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Dto: data transfer object:
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseDto<T> {
    private String status;
    private T data;
    private String message;
}

/*
 * { status: "00", data: [account], message: "success"}
 */
