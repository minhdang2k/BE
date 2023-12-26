package com.example.lab_session3_4.exception;

import com.example.lab_session3_4.dto.ResponseDTO;
import com.example.lab_session3_4.factory.interfaces.IResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerException {
    @Autowired
    @Qualifier("errorResponse")
    private  IResponseFactory errorFactory;


    @ExceptionHandler(AccountException.class)
    public ResponseEntity<ResponseDTO<Void>> handleException(AccountException e) {
//        return ResponseEntity.internalServerError().body(
//                ResponseDTO.<Void>builder().status(HttpStatus.INTERNAL_SERVER_ERROR).message(e.getMessage()).build()
//        );
        return errorFactory.custom(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
    }
}
