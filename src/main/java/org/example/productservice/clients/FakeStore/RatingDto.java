package org.example.productservice.clients.FakeStore;

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

    public Rating createRating() {
        Rating rating = new Rating();
        rating.setId(this.id);
        rating.setRate(this.rate);
        rating.setCount(this.count);
        return rating;
    }
}
