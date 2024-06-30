package org.example.productservice.controllers;

import org.example.productservice.dtos.ProductDto;
import org.example.productservice.models.Product;
import org.example.productservice.security.TokenValidator;
import org.example.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private TokenValidator tokenValidator;

    public ProductController(ProductService productService, TokenValidator tokenValidator) {
        this.productService = productService;
        this.tokenValidator = tokenValidator;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProducts(@PathVariable("id") Long id) {
        if (id <= 0) throw new IllegalArgumentException("Invalid id");
        Product product = productService.getProduct(id);
        if (product == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        ProductDto productDto = new ProductDto(product);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<Product> products = productService.getProducts();
        if (products == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(new ProductDto(product));
        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<ProductDto> addProduct(@RequestBody ProductDto productDto) {
        Product product = productService.createProduct(productDto);
        return new ResponseEntity<>(new ProductDto(), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ProductDto updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
