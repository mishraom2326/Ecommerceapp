package com.sheryians.major.service;

import com.sheryians.major.model.Category;
import com.sheryians.major.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();

    }

    public void addCategory(Category category){
        categoryRepository.save(category);

    }

    public void deleteCategorybyid(int id){
      categoryRepository.deleteById(id);
    }

    public Optional getCategorybyid(int id){
        Optional category=categoryRepository.findById(id);
        return category;
    }
}
