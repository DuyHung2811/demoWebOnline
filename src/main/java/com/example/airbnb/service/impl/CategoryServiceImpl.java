package com.example.airbnb.service.impl;

import com.example.airbnb.model.Category;
import com.example.airbnb.repository.CategoryRepository;
import com.example.airbnb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
