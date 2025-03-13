package com.Ecommerce.Project.Controller;


import com.Ecommerce.Project.Model.Category;
import com.Ecommerce.Project.Service.CategoryService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category>categories =  categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
       categoryService.createCategory(category);
        return new ResponseEntity<>("Category created",HttpStatus.CREATED);
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
            //return new ResponseEntity<>(status, HttpStatus.OK);
            //return ResponseEntity.ok(status);
            return ResponseEntity.status(HttpStatus.OK).body(status);
        }
        catch(ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PutMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category,
                                                 @PathVariable Long categoryId) {
        try{
             Category savedCategory = categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Category with category Id: "+categoryId,HttpStatus.OK);
        }catch(ResponseStatusException e){
            return  new  ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }
}
