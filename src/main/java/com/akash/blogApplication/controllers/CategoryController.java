package com.akash.blogApplication.controllers;


import com.akash.blogApplication.payloads.ApiResponse;
import com.akash.blogApplication.payloads.CategoryDto;
import com.akash.blogApplication.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto)
    {
        CategoryDto createdCategory= this.categoryService.createCategory(categoryDto);

        return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
    }

    //update

    @PostMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId)
    {
        CategoryDto updatedCategory= this.categoryService.updateCategory(categoryDto,categoryId);

        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory( @PathVariable Integer categoryId)
    {
         this.categoryService.deleteCategory(categoryId);

        return new ResponseEntity<ApiResponse>( new ApiResponse("Category is deleted successfully. ", true) ,HttpStatus.OK);
    }

    //get
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId)
    {
        CategoryDto categoryDto= this.categoryService.getCategory(categoryId);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }


    //get All

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategory()
    {
       List<CategoryDto> categoryDtoList    = this.categoryService.getCategories();
        return ResponseEntity.ok(categoryDtoList);
    }


}
