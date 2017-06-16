package ua.project;

import ua.project.matcher.ModelMatcher;
import ua.project.model.Dish;
import ua.project.model.Restaurant;

import java.util.Arrays;
import java.util.List;

import static ua.project.model.BaseEntity.START_SEQ;

/**
 * Created by naum_ on 15-Jun-17.
 */
public class RestaurantTestData {

    public static final int RESTAURANT1_ID = START_SEQ + 3;

    public static final Restaurant RESTAURANT1 = new Restaurant(RESTAURANT1_ID, "name1");
    public static final Restaurant RESTAURANT2 = new Restaurant(RESTAURANT1_ID + 1, "name2");

    public static final List<Restaurant> restaurants = Arrays.asList(RESTAURANT1, RESTAURANT2);

    public static final int DISH1_ID = RESTAURANT1_ID + 2;

    public static final Dish DISH1 = new Dish(DISH1_ID, "dish1", 1000, RESTAURANT1_ID);
    public static final Dish DISH2 = new Dish(DISH1_ID + 1, "dish2", 2000, RESTAURANT1_ID);
    public static final Dish DISH3 = new Dish(DISH1_ID + 2, "dish3", 3000, RESTAURANT1_ID + 1);
    public static final Dish DISH4 = new Dish(DISH1_ID + 3, "dish3", 4000, RESTAURANT1_ID + 1);

    public static final List<Dish> dishes = Arrays.asList(DISH1, DISH2, DISH3, DISH4);

    public static final ModelMatcher<Restaurant> RESTAURANT_MATCHER = new ModelMatcher<>();
    public static final ModelMatcher<Dish> DISH_MATCHER = new ModelMatcher<>();

    public static Restaurant getCreatedRestaurant() {
        return new Restaurant(null, "new");
    }

    public static Dish getCreatedDish() {
        return new Dish(null, "new", 500, null);
    }

}
