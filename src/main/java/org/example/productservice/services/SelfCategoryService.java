package org.example.productservice.services;

import org.example.productservice.models.Category;
import org.example.productservice.repositories.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfCategoryService implements CategoryService {
    @Autowired
    private CategoryRepo selfCategoryRepo;

    private SelfCategoryService(CategoryRepo selfCategoryRepo) {
        this.selfCategoryRepo = selfCategoryRepo;
    }

    public Category createCategory(Category category) {
        return selfCategoryRepo.save(category);
    }

    public List<Category> getCategories() {
        return selfCategoryRepo.findAll();
    }

    public Category getCategory(Long id) {
        return selfCategoryRepo.findById(id).orElse(null);
    }

    public Category updateCategory(Long id, Category category) {
        Category category1 = selfCategoryRepo.findById(id).orElse(null);
        if (category1!=null) {
            if (category.getName()!=null) category1.setName(category.getName());
            if (category.getDescription()!=null) category1.setDescription(category.getDescription());
            if (category.getProducts()!=null) category1.setProducts(category.getProducts());
            return selfCategoryRepo.save(category1);
        }
        return null;
    }
}
