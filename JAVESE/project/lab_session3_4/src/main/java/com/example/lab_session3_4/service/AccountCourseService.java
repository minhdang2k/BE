package com.example.lab_session3_4.service;

import com.example.lab_session3_4.dto.AccountCourseReqDTO;
import com.example.lab_session3_4.dto.AccountCourseResDTO;
import com.example.lab_session3_4.dto.ResponseDTO;
import com.example.lab_session3_4.entity.Account;
import com.example.lab_session3_4.entity.AccountCourse;
import com.example.lab_session3_4.entity.Course;
import com.example.lab_session3_4.mapper.Mapper;
import com.example.lab_session3_4.repository.AccountCourseRepository;
import com.example.lab_session3_4.repository.AccountRepository;
import com.example.lab_session3_4.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountCourseService {
    private final AccountCourseRepository accountCourseRepository;
    private final AccountRepository accountRepository;
    private final CourseRepository courseRepository;
    private final Mapper mapper;

    public AccountCourseService(AccountCourseRepository accountCourseRepository, AccountRepository accountRepository, CourseRepository courseRepository, Mapper mapper) {
        this.accountCourseRepository = accountCourseRepository;
        this.accountRepository = accountRepository;
        this.courseRepository = courseRepository;
        this.mapper = mapper;
    }

    public ResponseDTO<AccountCourseResDTO> create(AccountCourse accountCourse){
        AccountCourseResDTO res = mapper.mapToAccCourseDTO(accountCourseRepository.save(accountCourse));
        return ResponseDTO.<AccountCourseResDTO>builder()
                .status(HttpStatus.OK)
                .message("Assign course to user successfully.")
                .data(res)
                .build();
    }
    public ResponseDTO<Void> delete(Long account_id, Long course_id){
        Optional<AccountCourse> foundAccCourse = accountCourseRepository.findByAccount_IdAndCourse_Id(account_id,course_id);
        if (foundAccCourse.isEmpty()){
            return ResponseDTO.<Void>builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message("Not found Account assign in Course")
                    .build();
        }

        AccountCourse accountCourse = foundAccCourse.get();
        accountCourseRepository.deleteById(accountCourse.getId());
        return ResponseDTO.<Void>builder()
                .status(HttpStatus.OK)
                .message("Unassign the course success.")
                .build();
    }
}
