package org.example.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Product extends BaseModel {
    private String name;
    private Double price;
    private String description;
    @ManyToOne
    private Category category;
    @OneToOne(cascade = jakarta.persistence.CascadeType.ALL)
    private Rating rating;
    private String imageUrl;
}
