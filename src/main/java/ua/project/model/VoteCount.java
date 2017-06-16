package ua.project.model;

/**
 * Created by naum_ on 16-Jun-17.
 */
public class VoteCount {
    private Integer id;
    private Long count;
    private Restaurant restaurant;

    public VoteCount(Integer id, Long count, Restaurant restaurant) {
        this.id = id;
        this.count = count;
        this.restaurant = restaurant;
    }

    public VoteCount() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "VoteCount{" +
                "id=" + id +
                ", count=" + count +
                ", restaurant=" + restaurant +
                '}';
    }
}
