package com.akash.blogApplication.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {

    private Integer categoryId;

    @NotBlank
    @Size(min=4, message = "Category Title cannot have less than 4 characters.")
    private String categoryTitle;
    @NotBlank
    @Size(min=10, message = "Category Description cannot have less than 10 characters.")
    private String categoryDescription;

}
