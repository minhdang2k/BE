package com.example.lab_session3_4.controller;

import com.example.lab_session3_4.dto.ResponseDTO;
import com.example.lab_session3_4.factory.interfaces.IResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
    @Autowired
    @Qualifier("successResponse")
    private IResponseFactory successFactory;
    @Autowired
    @Qualifier("errorResponse")
    private IResponseFactory errorFactory;

    public <T> ResponseEntity<ResponseDTO<T>> success(T data){
        return successFactory.build(data);
    }
    public <T> ResponseEntity<ResponseDTO<T>> error(T data){
        return errorFactory.build(data);
    }
}
