package com.Ecommerce.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ecommerce.Project.Model.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByCategoryName(String categoryName);
}
