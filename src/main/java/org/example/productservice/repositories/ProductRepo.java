package org.example.productservice.repositories;

import org.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Product save(Product product);
    void deleteById(Long id);
}
