package org.example.productservice.clients.FakeStore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productservice.dtos.RatingDto;
import org.example.productservice.models.Category;
import org.example.productservice.models.Product;

import java.util.Date;

@Getter
@Setter
@ToString
public class FakeStoreDto {
    private Long id;
    private Date created;
    private Date modified;
    private Boolean isDeleted;
    private String name;
    private Double price;
    private String description;
    private String category;
    private String imageUrl;
    private RatingDto rating;

    public Product getProduct() {
        Product product = new Product();
        Category category = new Category();
        product.setId(this.id);
        product.setCreated(this.created);
        product.setModified(this.modified);
        product.setIsDeleted(this.isDeleted);
        product.setName(this.name);
        product.setPrice(this.price);
        product.setDescription(this.description);
        category.setDescription(this.category);
        product.setImageUrl(this.imageUrl);
        product.setCategory(category);
        if(this.rating!=null) product.setRating(this.rating.getRating());
        return product;
    }

    public static FakeStoreDto getProductDto(Product product) {
        FakeStoreDto fakeStoreDto = new FakeStoreDto();
        fakeStoreDto.setId(product.getId());
        fakeStoreDto.setCreated(product.getCreated());
        fakeStoreDto.setModified(product.getModified());
        fakeStoreDto.setIsDeleted(product.getIsDeleted());
        fakeStoreDto.setName(product.getName());
        fakeStoreDto.setPrice(product.getPrice());
        fakeStoreDto.setDescription(product.getDescription());
        fakeStoreDto.setCategory(product.getCategory().getDescription());
        fakeStoreDto.setImageUrl(product.getImageUrl());
        return fakeStoreDto;
    }
}
