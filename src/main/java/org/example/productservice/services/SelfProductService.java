package org.example.productservice.services;

import jakarta.transaction.Transactional;
import org.example.productservice.dtos.ProductDto;
import org.example.productservice.models.Product;
import org.example.productservice.repositories.CategoryRepo;
import org.example.productservice.repositories.ProductRepo;
import org.example.productservice.repositories.RatingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService {
    ProductRepo selfProductRepo;
    CategoryRepo selfCategoryRepo;
    RatingRepo selfRatingRepo;

    public SelfProductService(ProductRepo selfRepo, CategoryRepo selfCategoryRepo, RatingRepo selfRatingRepo) {
        this.selfProductRepo = selfRepo;
        this.selfCategoryRepo = selfCategoryRepo;
        this.selfRatingRepo = selfRatingRepo;
    }
    @Override
    @Transactional
    public Product createProduct(ProductDto productDto) {
        Product product = productDto.getProduct();
        selfCategoryRepo.save(product.getCategory());
        selfRatingRepo.save(product.getRating());
        return selfProductRepo.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return selfProductRepo.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return selfProductRepo.findById(id).orElse(null);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product product = selfProductRepo.findById(id).orElse(null);
        if (productDto==null) return null;
        if (product != null) {
            if (productDto.getName()!=null) product.setName(productDto.getName());
            if (productDto.getPrice()!=null) product.setPrice(productDto.getPrice());
            if (productDto.getCategoryDto()!=null) product.setCategory(productDto.getCategoryDto().getCategory());
            if (productDto.getRatingDto()!=null) product.setRating(productDto.getRatingDto().getRating());
            if (productDto.getDescription()!=null) product.setDescription(productDto.getDescription());
            if (productDto.getImageUrl()!=null) product.setImageUrl(productDto.getImageUrl());
        }
        if (product!=null) selfProductRepo.save(product);
        return productDto;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = selfProductRepo.findById(id).orElse(null);
        if (product!=null) {
            product.setIsDeleted(true);
            selfProductRepo.save(product);
        }
    }
}
