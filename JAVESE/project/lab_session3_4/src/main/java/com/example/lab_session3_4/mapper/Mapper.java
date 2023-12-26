package com.example.lab_session3_4.mapper;

import com.example.lab_session3_4.dto.AccountCourseResDTO;
import com.example.lab_session3_4.dto.CategoryDTO;
import com.example.lab_session3_4.dto.CourseDTO;
import com.example.lab_session3_4.dto.UserAccountResDTO;
import com.example.lab_session3_4.entity.Account;
import com.example.lab_session3_4.entity.AccountCourse;
import com.example.lab_session3_4.entity.Category;
import com.example.lab_session3_4.entity.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public UserAccountResDTO mapToUserAccountDTO(Account account){
        UserAccountResDTO userAccountResDTO = new UserAccountResDTO();
        userAccountResDTO.setFirstName(account.getUser().getFirstName());
        userAccountResDTO.setLastName(account.getUser().getLastName());
        userAccountResDTO.setEmail(account.getUser().getEmail());
        userAccountResDTO.setUsername(account.getUsername());
        return userAccountResDTO;
    }
    public List<UserAccountResDTO> mapToListUserAccountDTO(List<Account> list){
        return list.stream().map(this::mapToUserAccountDTO).collect(Collectors.toList());
    }

    public CategoryDTO mapToCateDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
    public List<CategoryDTO> mapToListCateDTO(List<Category> list){
        return list.stream().map(this::mapToCateDTO).collect(Collectors.toList());
    }

    public CourseDTO mapToCourseDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setStartDate(course.getStartDate());
        courseDTO.setEndDate(course.getEndDate());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setCategoryName(course.getCategory().getName());

        return courseDTO;
    }
    public List<CourseDTO> mapToListCourseDTO(List<Course> list){
        return list.stream().map(this::mapToCourseDTO).collect(Collectors.toList());
    }

    public AccountCourseResDTO mapToAccCourseDTO(AccountCourse accountCourse){
        AccountCourseResDTO accountCourseResDTO = new AccountCourseResDTO();
        accountCourseResDTO.setAccountDTO(mapToUserAccountDTO(accountCourse.getAccount()));
        accountCourseResDTO.setCourseDTO(mapToCourseDTO(accountCourse.getCourse()));
        accountCourseResDTO.setRegistrationDate(accountCourse.getRegisDate());
        accountCourseResDTO.setPurchasePrice(accountCourse.getPurchase());
        return accountCourseResDTO;
    }
}
