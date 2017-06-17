package ua.project.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by naum_ on 13-Jun-17.
 */
@Entity
@Table(name = "dishes")
public class Dish extends NamedEntity {

    @Column(name = "price", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Integer price;

    @Column(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Integer restaurantId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restaurant_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @NotNull
//    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, String name, Integer price, Integer restaurantId) {
        super(id, name);
        this.price = price;
        this.restaurantId = restaurantId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

//    public Restaurant getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Restaurant restaurant) {
//        this.restaurant = restaurant;
//    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", restaurantID=" + restaurantId +
                ", id=" + id +
                '}';
    }
}
