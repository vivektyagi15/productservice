package org.example.productservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;
import org.example.productservice.models.Product;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductDto {
    private Long id;
    private Date created;
    private Date modified;
    private Boolean isDeleted;
    private String name;
    private Double price;
    private String description;
    @ToString.Exclude
    private CategoryDto categoryDto;
    @ToString.Exclude
    private RatingDto ratingDto;
    private String imageUrl;

    public ProductDto() {
    }

    public ProductDto(@NotNull Product product) {
        if (product.getId()!=null) this.id = product.getId();
        if (product.getCreated()!=null) this.created= product.getCreated();
        if (product.getModified()!=null) this.modified = product.getModified();
        if (product.getIsDeleted()!=null) this.isDeleted = product.getIsDeleted();
        if (product.getName()!=null) this.name = product.getName();
        if (product.getPrice()!=null) this.price = product.getPrice();
        if (product.getDescription()!=null) this.description = product.getDescription();
        if (product.getCategory()!=null) this.categoryDto = new CategoryDto(product.getCategory());
        if (product.getRating()!=null) this.ratingDto = new RatingDto(product.getRating());
        this.imageUrl = product.getImageUrl();
    }

    @JsonIgnore
    public Product getProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setCreated(this.created);
        product.setModified(this.modified);
        product.setIsDeleted(this.isDeleted);
        product.setName(this.name);
        product.setPrice(this.price);
        product.setDescription(this.description);
        if (this.categoryDto != null) product.setCategory(this.categoryDto.getCategory());
        if (this.ratingDto != null) product.setRating(this.ratingDto.getRating());
        product.setImageUrl(this.imageUrl);
        return product;
    }
}
