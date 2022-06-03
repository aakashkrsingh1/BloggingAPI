package com.akash.blogApplication.services;

import com.akash.blogApplication.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {



    //create
    public CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    //delete

    void deleteCategory(Integer categoryId);

    //get
    CategoryDto getCategory(Integer categoryId);

    //getAll
    List<CategoryDto> getCategories();
}
