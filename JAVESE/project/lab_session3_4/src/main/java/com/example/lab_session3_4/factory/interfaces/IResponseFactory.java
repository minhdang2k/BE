package com.example.lab_session3_4.factory.interfaces;

import com.example.lab_session3_4.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface IResponseFactory {
    <T> ResponseEntity<ResponseDTO<T>> build(T data);
    <T> ResponseEntity<ResponseDTO<T>> custom(HttpStatus status, String message, T data);
}
