package com.example.lab_session3_4.service;

import com.example.lab_session3_4.dto.CategoryDTO;
import com.example.lab_session3_4.dto.ResponseDTO;
import com.example.lab_session3_4.entity.Category;
import com.example.lab_session3_4.entity.Course;
import com.example.lab_session3_4.mapper.Mapper;
import com.example.lab_session3_4.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryService{

    private final CategoryRepository categoryRepository;
    private final Mapper mapper;

    public CategoryService(CategoryRepository categoryRepository, Mapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public ResponseDTO<CategoryDTO> create(CategoryDTO newCate){
        Optional<Category> foundCate = categoryRepository.findByName(newCate.getName());
        if (foundCate.isPresent()){
            return ResponseDTO.<CategoryDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Category's name is exists").build();
        }

        Category category = new Category();
        category.setName(newCate.getName());

        CategoryDTO resCate = mapper.mapToCateDTO(categoryRepository.save(category));
        return ResponseDTO.<CategoryDTO>builder().status(HttpStatus.OK).message("Create Category Successfully.").data(resCate).build();
    }
    public ResponseDTO<CategoryDTO> findById(Long id) {
        Optional<Category> foundCate = categoryRepository.findById(id);
        if (foundCate.isEmpty()){
            return ResponseDTO.<CategoryDTO>builder().status(HttpStatus.NOT_FOUND).message("Not Found category with id = " + id + ".").build();
        }
        Category category = foundCate.get();
        CategoryDTO categoryDTO = mapper.mapToCateDTO(category);
        return ResponseDTO.<CategoryDTO>builder().status(HttpStatus.OK).message("Found category with id = " + id + ".").data(categoryDTO).build();
    }
    public ResponseDTO<List<CategoryDTO>> findAll() {
        List<Category> list = categoryRepository.findAll();
        if (list.isEmpty()){
            return ResponseDTO.<List<CategoryDTO>>builder().status(HttpStatus.NOT_FOUND).message("Not found list categories").build();
        }

        List<CategoryDTO> listRes = mapper.mapToListCateDTO(list);
        return ResponseDTO.<List<CategoryDTO>>builder().status(HttpStatus.OK).message("Found list categories").data(listRes).build();
    }
    public ResponseDTO<Void> deleteById(Long id) {
        Optional<Category> foundCate = categoryRepository.findById(id);
        if (foundCate.isPresent()){
            // TODO: 12/7/2023 Prevent deletion of categories that are currently in use by any course
            Set<Course> courses = foundCate.get().getCourses();
            if (!courses.isEmpty()){
                return ResponseDTO.<Void>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Delete fail, this category is currently in use").build();
            }
            categoryRepository.deleteById(id);
            return ResponseDTO.<Void>builder().status(HttpStatus.OK).message("Deleted category with id = " + id + ".").build();
        }
        return ResponseDTO.<Void>builder().status(HttpStatus.NOT_FOUND).message("Not found category with id = " + id + ".").build();
    }
    public ResponseDTO<Void> deleteByIdIn(List<Long> longs) {
        StringBuilder msg = new StringBuilder();
        msg.append("Detail deleted:\n");
        List<Long> newList = longs.stream().filter(item -> {
            Optional<Category> foundCate = categoryRepository.findById(item);
            if (foundCate.isPresent()){
                Category category = foundCate.get();
                Set<Course> courses = category.getCourses();
                if (courses.isEmpty()){
                    return true;
                } else {
                    msg.append(category.getName()).append(" in use\n");
                    return false;
                }
            } else {
                msg.append("Not found id = ").append(item).append("\n");
                return false;
            }

        }).toList();

        categoryRepository.deleteByIdIn(newList);
        return ResponseDTO.<Void>builder().status(HttpStatus.OK).message(msg.toString()).build();
    }
    public ResponseDTO<CategoryDTO> updateById(CategoryDTO cateUpdate, Long id){
        Optional<Category> foundCate = categoryRepository.findById(id);
        if (foundCate.isPresent()){
            Optional<Category> foundCateByName = categoryRepository.findByName(cateUpdate.getName());
            if (foundCateByName.isPresent() && !cateUpdate.getName().equals(foundCate.get().getName())){
                return ResponseDTO.<CategoryDTO>builder().status(HttpStatus.NOT_IMPLEMENTED).message("Category's name is exists").build();
            }

            Category category = foundCate.get();
            category.setName(cateUpdate.getName());

            CategoryDTO res = mapper.mapToCateDTO(categoryRepository.save(category));
            return ResponseDTO.<CategoryDTO>builder().status(HttpStatus.OK).message("Updated category with id = " + id + ".").data(res).build();
        }
        return ResponseDTO.<CategoryDTO>builder().status(HttpStatus.NOT_FOUND).message("Not found category with id = " + id + ".").build();
    }
}
