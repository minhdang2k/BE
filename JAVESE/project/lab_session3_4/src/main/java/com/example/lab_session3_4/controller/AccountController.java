package com.example.lab_session3_4.controller;

import com.example.lab_session3_4.dto.AccountCourseResDTO;
import com.example.lab_session3_4.dto.UserAccountResDTO;
import com.example.lab_session3_4.dto.UserAccountReqDTO;
import com.example.lab_session3_4.dto.ResponseDTO;
import com.example.lab_session3_4.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RestControllerAdvice
public class AccountController extends BaseController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/")
    public ResponseEntity<ResponseDTO<UserAccountResDTO>> create(@RequestBody UserAccountReqDTO account){
        ResponseDTO<UserAccountResDTO> res = accountService.create(account);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO<UserAccountResDTO>> updateById(@RequestBody UserAccountReqDTO account, @PathVariable Long id){
        ResponseDTO<UserAccountResDTO> res = accountService.updateById(account, id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @GetMapping("/")
    public ResponseEntity<ResponseDTO<List<UserAccountResDTO>>> findAll(){
        List<UserAccountResDTO> res = accountService.findAll();
        return success(res);
        //return ResponseEntity.status(res.getStatus()).body(res);
    }

    @GetMapping("")
    public ResponseEntity<ResponseDTO<List<UserAccountResDTO>>> findAllWithPagingAndSorting(@RequestParam(name = "offset") int offset, @RequestParam(name = "pageSize") int pageSize, @RequestParam(name = "field") String field){
        List<UserAccountResDTO> res = accountService.findAllWithPagingAndSorting(offset,pageSize,field);
        return success(res);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<UserAccountResDTO>> findById(@PathVariable Long id){
        UserAccountResDTO res = accountService.findById(id);
//        return ResponseEntity.status(res.getStatus()).body(res);
        return success(res);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO<Void>> deleteById(@PathVariable Long id){
        ResponseDTO<Void> res = accountService.deleteById(id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @PutMapping("/{id}/{type}")
    public ResponseEntity<ResponseDTO<UserAccountResDTO>> updateStatus(@PathVariable Long id, @PathVariable String type){
        ResponseDTO<UserAccountResDTO> res = accountService.updateStatus(id, type);
        return ResponseEntity.status(res.getStatus()).body(res);
    }

    @PostMapping("/{account_id}/assign/{course_id}")
    public ResponseEntity<ResponseDTO<AccountCourseResDTO>> assignCourse(@PathVariable Long account_id, @PathVariable Long course_id){
        ResponseDTO<AccountCourseResDTO> res = accountService.assignCourse(account_id, course_id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }
    @PostMapping("/{account_id}/unassign/{course_id}")
    public ResponseEntity<ResponseDTO<Void>> unAssignCourse(@PathVariable Long account_id, @PathVariable Long course_id){
        ResponseDTO<Void> res = accountService.unAssignCourse(account_id, course_id);
        return ResponseEntity.status(res.getStatus()).body(res);
    }


}
