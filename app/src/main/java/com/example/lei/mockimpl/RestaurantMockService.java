package com.example.lei.mockimpl;

import com.example.lei.backends.api.RestaurantService;
import com.example.lei.foodordering.R;
import com.leiwang.foodordering.domain.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMockService implements RestaurantService {
    private List<Restaurant> _restaurantList = new ArrayList<>();

    private Restaurant createRest(int id, String name, int imageId, int categoryId) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(id);
        restaurant.setName(name);
        restaurant.setImage(imageId);
        restaurant.setCategoryId(categoryId);
        return restaurant;
    }

    public RestaurantMockService() {
        Restaurant american1 = createRest(101, "Black Bear Diner", R.drawable.american, 1);
        _restaurantList.add(american1);
        Restaurant american2 = createRest(102,"California Pizza", R.drawable.american2, 1);
        _restaurantList.add(american2);
        Restaurant american3 = createRest(103,"The Cheesecake Factory", R.drawable.american1, 1);
        _restaurantList.add(american3);
        Restaurant japanese1 = createRest(201,"Kaenyama Sushi and Yakiniku", R.drawable.japanese, 2);
        _restaurantList.add(japanese1);
        Restaurant japanese2 = createRest(202,"Osaka Ramen", R.drawable.japanese1, 2);
        _restaurantList.add(japanese2);
        Restaurant italian = createRest(301,"Olive Garden Italian Restaurant", R.drawable.italian, 3);
        _restaurantList.add(italian);
        Restaurant indian = createRest(401,"Tandoori N Curry", R.drawable.indian, 4);
        _restaurantList.add(indian);
        Restaurant chinese = createRest(501,"Verde tea Espresso Bar", R.drawable.chinese, 5);
        _restaurantList.add(chinese);
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurant(){
        return _restaurantList;
    }
}
