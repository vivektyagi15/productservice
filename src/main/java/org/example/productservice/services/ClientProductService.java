package org.example.productservice.services;

import org.example.productservice.clients.Client;
import org.example.productservice.dtos.ProductDto;
import org.example.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class ClientProductService implements ProductService {
    @Autowired
    private Client client;

    public ClientProductService(Client client) {
        this.client = client;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        return client.addProduct(productDto.getProduct());
    }

    @Override
    public List<Product> getProducts() {
        return client.getProducts();
    }

    @Override
    public Product getProduct(Long id) {
        return client.getProduct(id);
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) throws IllegalArgumentException {
        return null;
    }
}
