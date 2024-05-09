package org.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productservice.models.Rating;

@Getter
@Setter
@ToString
public class RatingDto {
    private Long id;
    private String rate;
    private Integer count;

    public RatingDto(Rating rating) {
        if (rating.getId()!=null) this.id = rating.getId();
        if (rating.getRate()!=null) this.rate = rating.getRate();
        if (rating.getCount()!=null) this.count = rating.getCount();
    }

    public RatingDto() {}

    public Rating getRating() {
        Rating rating = new Rating();
        rating.setId(this.id);
        rating.setRate(this.rate);
        rating.setCount(this.count);
        return rating;
    }
}
