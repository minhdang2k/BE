package com.example.lab_session3_4.factory.response;

import com.example.lab_session3_4.constant.ResposeConstant;
import com.example.lab_session3_4.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseFactory {
    private ResponseFactory(){}
    public <T>ResponseEntity<ResponseDTO<T>> success(T data){
        return ResponseEntity.ok(
                ResponseDTO.<T>builder()
                        .status(HttpStatus.OK)
                        .message(ResposeConstant.SUCCESS_MESSAGE)
                        .data(data)
                        .build()
        );
    }
    public <T>ResponseEntity<ResponseDTO<T>> error(T data){
        return ResponseEntity.internalServerError().body(
                ResponseDTO.<T>builder()
                        .status(HttpStatus.OK)
                        .message(ResposeConstant.SUCCESS_MESSAGE)
                        .data(data)
                        .build()
        );
    }
}
