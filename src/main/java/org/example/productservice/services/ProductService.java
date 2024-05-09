package org.example.productservice.services;

import org.example.productservice.dtos.ProductDto;
import org.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductDto productDto);
    List<Product> getProducts();
    Product getProduct(Long id);
    void deleteProduct(Long id);

    ProductDto updateProduct(Long id, ProductDto productDto);
}
