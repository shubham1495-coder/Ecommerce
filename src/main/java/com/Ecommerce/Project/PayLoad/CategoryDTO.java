package com.Ecommerce.Project.PayLoad;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long CategoryId;
    private String categoryName;
}
