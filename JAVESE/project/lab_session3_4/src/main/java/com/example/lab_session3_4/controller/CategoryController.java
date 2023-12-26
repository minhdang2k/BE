package com.example.lab_session3_4.controller;

import com.example.lab_session3_4.dto.CategoryDTO;
import com.example.lab_session3_4.dto.ResponseDTO;

import com.example.lab_session3_4.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public ResponseEntity<ResponseDTO<CategoryDTO>> create(@RequestBody CategoryDTO categoryDTO){
        ResponseDTO<CategoryDTO> res = categoryService.create(categoryDTO);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ResponseDTO<CategoryDTO>> updateById(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id){
        ResponseDTO<CategoryDTO> res = categoryService.updateById(categoryDTO,id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @GetMapping("/")
    public ResponseEntity<ResponseDTO<List<CategoryDTO>>> findAll(){
        ResponseDTO<List<CategoryDTO>> res = categoryService.findAll();
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<CategoryDTO>> findById(@PathVariable Long id){
        ResponseDTO<CategoryDTO> res = categoryService.findById(id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Void>> deleteById(@PathVariable Long id){
        ResponseDTO<Void> res = categoryService.deleteById(id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @DeleteMapping("")
    public ResponseEntity<ResponseDTO<Void>> deleteById(@RequestParam("ids") List<Long> ids){
        ResponseDTO<Void> res = categoryService.deleteByIdIn(ids);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
}
