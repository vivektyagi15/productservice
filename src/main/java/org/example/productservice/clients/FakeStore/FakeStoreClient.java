package org.example.productservice.clients.FakeStore;

import org.example.productservice.clients.Client;
import org.example.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClient implements Client {
    private final RestTemplateBuilder restTemplateBuilder;
    private String url = "https://fakestoreapi.com/products";

    public FakeStoreClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public Product getProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        return restTemplate.getForObject(url+"/"+id, FakeStoreDto.class).getProduct();
    }

    @Override
    public List<Product> getProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreDto[] fakeStoreDtos = restTemplate.getForObject(url, FakeStoreDto[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreDto fakeStoreDto : fakeStoreDtos) {
            products.add(fakeStoreDto.getProduct());
        }
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForObject(url, FakeStoreDto.getProductDto(product), FakeStoreDto.class);
        return product;
    }
}
