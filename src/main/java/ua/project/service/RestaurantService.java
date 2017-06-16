package ua.project.service;

import ua.project.model.Dish;
import ua.project.model.Restaurant;

import java.util.List;

/**
 * Created by naum_ on 14-Jun-17.
 */
public interface RestaurantService {

    Restaurant save(Restaurant restaurant);

    void delete(int id);

    List<Restaurant> getAll();

    Restaurant get(int id);

    Dish saveDish(Dish dish);

    void deleteDish(int dishId);

    void deleteMenu(int restaurantId);

    List<Dish> getMenu(int restaurantId);
}
