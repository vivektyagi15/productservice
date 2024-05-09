package org.example.productservice.services;

import org.example.productservice.models.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    List<Category> getCategories();
    Category getCategory(Long id);
    Category updateCategory(Long id, Category category);
}
