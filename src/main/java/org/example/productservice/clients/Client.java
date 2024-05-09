package org.example.productservice.clients;

import org.example.productservice.models.Product;

import java.util.List;

public interface Client {
    Product getProduct(Long id);
    List<Product> getProducts();
    Product addProduct(Product product);
}
