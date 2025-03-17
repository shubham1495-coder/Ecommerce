package com.Ecommerce.Project.Service;

import com.Ecommerce.Project.Model.Category;
import com.Ecommerce.Project.PayLoad.CategoryDTO;
import com.Ecommerce.Project.PayLoad.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse getAllCategories();

    CategoryDTO createCategory(CategoryDTO categoryDTO );
    CategoryDTO deleteCategory(Long categoryId);
    CategoryDTO updateCategory(CategoryDTO categoryDTO,Long categoryId);
}