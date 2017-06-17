package ua.project.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.project.RestaurantTestData;
import ua.project.model.Dish;
import ua.project.model.Restaurant;
import ua.project.repository.JpaUtil;
import ua.project.service.AbstractServiceTest;
import ua.project.service.RestaurantService;

import java.util.Arrays;

import static ua.project.RestaurantTestData.*;

/**
 * Created by naum_ on 15-Jun-17.
 */
public class RestaurantServiceImplTest extends AbstractServiceTest {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    protected JpaUtil jpaUtil;


    @Before
    public void setUp() throws Exception {
        restaurantService.evictCache();
        jpaUtil.clear2ndLevelHibernateCache();
    }

    @Test
    public void save() throws Exception {
        //create
        Restaurant newRestaurant = getCreatedRestaurant();
        Restaurant created = restaurantService.save(newRestaurant);
        newRestaurant.setId(created.getId());
        RESTAURANT_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT1, RESTAURANT2, newRestaurant), restaurantService.getAll());
        Dish createdDish = RestaurantTestData.getCreatedDish();
        createdDish.setRestaurantId(newRestaurant.getId());
        restaurantService.saveDish(createdDish);
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(createdDish),restaurantService.getMenu(newRestaurant.getId()));
        //update
        newRestaurant.setName("updatedName");
        restaurantService.save(newRestaurant);
        RESTAURANT_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT1, RESTAURANT2, newRestaurant), restaurantService.getAll());
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(createdDish),restaurantService.getMenu(newRestaurant.getId()));
    }

    @Test
    public void delete() throws Exception {
        restaurantService.delete(RESTAURANT1_ID);
        RESTAURANT_MATCHER.assertCollectionEquals(Arrays.asList(RESTAURANT2), restaurantService.getAll());
    }

    @Test
    public void getAll() throws Exception {
        RESTAURANT_MATCHER.assertCollectionEquals(RestaurantTestData.restaurants, restaurantService.getAll());
    }

    @Test
    public void get() throws Exception {
        Restaurant restaurant = restaurantService.get(RESTAURANT1_ID);
        RESTAURANT_MATCHER.assertEquals(restaurant, RESTAURANT1);
    }

    @Test
    public void saveDish() throws Exception {
        //create
        Dish newDish = getCreatedDish();
        newDish.setRestaurantId(RESTAURANT1_ID);
        Dish created = restaurantService.saveDish(newDish);
        newDish.setId(created.getId());
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH1, DISH2, newDish), restaurantService.getMenu(RESTAURANT1_ID));
        //update
        newDish.setPrice(5000);
        restaurantService.saveDish(newDish);
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH1, DISH2, newDish), restaurantService.getMenu(RESTAURANT1_ID));


    }

    @Test
    public void deleteDish() throws Exception {
        restaurantService.deleteDish(DISH1_ID);
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH2), restaurantService.getMenu(RESTAURANT1_ID));
    }

    @Test
    public void deleteMenu() throws Exception {
        restaurantService.deleteMenu(RESTAURANT1_ID);
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(), restaurantService.getMenu(RESTAURANT1_ID));
    }

    @Test
    public void getMenu() throws Exception {
        DISH_MATCHER.assertCollectionEquals(Arrays.asList(DISH1,DISH2), restaurantService.getMenu(RESTAURANT1_ID));
    }

}