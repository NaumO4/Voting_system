package ua.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.project.model.Restaurant;

import java.util.List;
import java.util.Map;

/**
 * Created by naum_ on 14-Jun-17.
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant save(Restaurant restaurant);

    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    List<Restaurant> findAll();

    Restaurant findOne(int id);
}
