package ua.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ua.project.model.Dish;
import ua.project.model.Restaurant;
import ua.project.repository.DishRepository;
import ua.project.repository.RestaurantRepository;
import ua.project.service.RestaurantService;

import java.util.List;

import static ua.project.util.ValidationUtil.checkNotFoundWithId;

/**
 * Created by naum_ on 14-Jun-17.
 */
@Service
@Transactional(readOnly = true)
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);
    }

    @Override
    @Transactional
    public void delete(int id) {
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant get(int id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    @Transactional
    public Dish saveDish(Dish dish) {
        Assert.notNull(dish, "restaurant must not be null");
        return dishRepository.save(dish);
    }

    @Override
    @Transactional
    public void deleteDish(int dishId) {
        dishRepository.delete(dishId);
    }

    @Override
    @Transactional
    public void deleteMenu(int restaurantId) {
        dishRepository.deleteAllByRestaurantId(restaurantId);
    }

    @Override
    public List<Dish> getMenu(int restaurantId) {
        return dishRepository.findAllByRestaurantId(restaurantId);
    }
}
