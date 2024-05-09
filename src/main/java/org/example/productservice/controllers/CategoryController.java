package org.example.productservice.controllers;

import org.example.productservice.models.Category;
import org.example.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable("id") Long id) {
        return categoryService.getCategory(id);
    }

    @GetMapping("")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PatchMapping("/{id}")
    public Category updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    public void deleteCategory(@PathVariable("id") Long id) {
    }
}
