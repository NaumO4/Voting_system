package ua.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.project.model.Dish;

import java.util.List;

/**
 * Created by naum_ on 14-Jun-17.
 */
@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> findAllByRestaurantId(int restaurantId);

    @Transactional
    int deleteAllByRestaurantId(int restaurantId);

}
