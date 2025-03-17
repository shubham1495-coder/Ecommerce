package com.Ecommerce.Project.Controller;


import com.Ecommerce.Project.PayLoad.CategoryDTO;
import com.Ecommerce.Project.PayLoad.CategoryResponse;
import com.Ecommerce.Project.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }

  //  @RequestMapping(value="/api/public/categories",method = RequestMethod.GET)
    @GetMapping("/api/public/categories")
      public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponse,HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO,HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
            CategoryDTO deletedCategory = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(deletedCategory,HttpStatus.OK);
    }

    @PutMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                 @PathVariable Long categoryId) {
             CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO,categoryId);
            return new ResponseEntity<>(savedCategoryDTO,HttpStatus.OK);
    }
}
