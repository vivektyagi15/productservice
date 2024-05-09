package org.example.productservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productservice.models.Category;

import java.util.Date;

@Getter
@Setter
@ToString
public class CategoryDto {
    private Long id;
    private Date created;
    private Date modified;
    private Boolean isDeleted;
    private String name;
    private String description;

    public CategoryDto(Category category) {
        if (category.getId()!=null) this.id = category.getId();
        if (category.getCreated()!=null) this.created= category.getCreated();
        if (category.getModified()!=null) this.modified = category.getModified();
        if (category.getIsDeleted()!=null) this.isDeleted = category.getIsDeleted();
        if (category.getName()!=null) this.name = category.getName();
        if (category.getDescription()!=null) this.description = category.getDescription();
    }

    public CategoryDto() {}

    @JsonIgnore
    public Category getCategory() {
        Category category = new Category();
        category.setId(this.id);
        category.setCreated(this.created);
        category.setModified(this.modified);
        category.setIsDeleted(this.isDeleted);
        category.setName(this.name);
        category.setDescription(this.description);
        return category;
    }
}
