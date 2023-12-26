package com.example.lab_session3_4.service;

import com.example.lab_session3_4.dto.*;
import com.example.lab_session3_4.entity.Account;
import com.example.lab_session3_4.entity.Category;
import com.example.lab_session3_4.entity.Course;
import com.example.lab_session3_4.entity.User;
import com.example.lab_session3_4.mapper.Mapper;
import com.example.lab_session3_4.repository.CategoryRepository;
import com.example.lab_session3_4.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final Mapper mapper;

    public CourseService(CourseRepository courseRepository, CategoryRepository categoryRepository, Mapper mapper) {
        this.courseRepository = courseRepository;
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public ResponseDTO<CourseDTO> create(CourseDTO newCourse) {
        Course course = new Course();
        course.setName(newCourse.getName());
        course.setDescription(newCourse.getDescription());
        course.setStartDate(newCourse.getStartDate());
        course.setEndDate(newCourse.getEndDate());
        course.setPrice(newCourse.getPrice());

        Optional<Category> foundCate = categoryRepository.findByName(newCourse.getCategoryName());
        if (foundCate.isPresent()) {// nếu tồn tại category thì thêm cate vào course và thêm course vào set course trong cate
            Category category = foundCate.get();
            course.setCategory(category);

            Set<Course> currCourses = category.getCourses();
            currCourses.add(course);

            category.setCourses(currCourses);

            categoryRepository.save(category);

            CourseDTO res = mapper.mapToCourseDTO(courseRepository.save(course));
            return ResponseDTO.<CourseDTO>builder().status(HttpStatus.OK).message("Create Course Successfully").data(res).build();
        }
        return ResponseDTO.<CourseDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Category does not exists").build();
    }

    public ResponseDTO<CourseDTO> findById(Long id) {
        Optional<Course> foundCourse = courseRepository.findById(id);
        if (foundCourse.isPresent()) {
            Course course = foundCourse.get();
            CourseDTO res = mapper.mapToCourseDTO(course);
            return ResponseDTO.<CourseDTO>builder().status(HttpStatus.OK).message("Found course with id = " + id + ".").data(res).build();
        }
        return ResponseDTO.<CourseDTO>builder().status(HttpStatus.NOT_FOUND).message("Not Found course with id = " + id + ".").build();
    }

    public ResponseDTO<List<CourseDTO>> findAll() {
        List<Course> list = courseRepository.findAll();
        if (list.isEmpty()) {
            return ResponseDTO.<List<CourseDTO>>builder().status(HttpStatus.NOT_FOUND).message("Not found list accounts").build();
        }
        List<CourseDTO> listRes = mapper.mapToListCourseDTO(list);
        return ResponseDTO.<List<CourseDTO>>builder().status(HttpStatus.OK).message("Found list accounts").data(listRes).build();
    }

    public ResponseDTO<Void> deleteById(Long id) {
        Optional<Course> foundCourse = courseRepository.findById(id);
        if (foundCourse.isPresent()) {
            courseRepository.deleteById(id);
            return ResponseDTO.<Void>builder().status(HttpStatus.OK).message("Deleted course with id = " + id + ".").build();
        }
        return ResponseDTO.<Void>builder().status(HttpStatus.NOT_FOUND).message("Not found course to delete with id = " + id + ".").build();
    }

    public ResponseDTO<CourseDTO> updateById(CourseDTO courseUpdate, Long id) {
        Optional<Category> foundCate = categoryRepository.findByName(courseUpdate.getCategoryName());
        if (foundCate.isEmpty()) {
            return ResponseDTO.<CourseDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Not found category to update course with id = " + id + ".").build();
        }

        Optional<Course> foundCourse = courseRepository.findById(id);
        if (foundCourse.isPresent()) {
            Course course = foundCourse.get();
            Category cateUpdate = foundCate.get();

            course.setName(courseUpdate.getName());
            course.setDescription(courseUpdate.getDescription());
            course.setStartDate(courseUpdate.getStartDate());
            course.setEndDate(courseUpdate.getEndDate());
            course.setPrice(courseUpdate.getPrice());
            if (!courseUpdate.getCategoryName().equals(course.getCategory().getName())) {
                //Remove course in curr category
                Category currCate = course.getCategory();
                Set<Course> currCourses = currCate.getCourses();
                currCourses.remove(course);
                categoryRepository.save(currCate);

                //update cate in course
                course.setCategory(cateUpdate);

                //add course into cate request
                Set<Course> cateUpdateCourse = cateUpdate.getCourses();
                cateUpdateCourse.add(course);
                cateUpdate.setCourses(cateUpdateCourse);
                categoryRepository.save(cateUpdate);
            }
            CourseDTO res = mapper.mapToCourseDTO(courseRepository.save(course));
            return ResponseDTO.<CourseDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Update account success with id = " + id + ".").data(res).build();
        }
        return ResponseDTO.<CourseDTO>builder().status(HttpStatus.NOT_FOUND).message("Not found account to update with id = " + id + ".").build();
    }

}
