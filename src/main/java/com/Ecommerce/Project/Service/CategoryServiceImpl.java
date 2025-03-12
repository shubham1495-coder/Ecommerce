package com.Ecommerce.Project.Service;

import com.Ecommerce.Project.Model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.print.attribute.standard.ReferenceUriSchemesSupported.HTTPS;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Category> getAllCategories(){
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
                .filter(c->c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(()
                        ->new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));
        categories.remove(category);
        return "Category with category Id: " + categoryId + " has been deleted";
    }

    @Override
    public Category updateCategory(Category category,Long categoryId){
        Optional<Category> optionalCategory = categories.stream()
                .filter(c-> Objects.equals(c.getCategoryId(),categoryId))
                .findFirst();
        if(optionalCategory.isPresent()){
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            return existingCategory;
        }else{
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found");
        }
    }
}
