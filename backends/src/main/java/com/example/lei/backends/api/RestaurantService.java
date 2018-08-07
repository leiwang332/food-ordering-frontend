package com.example.lei.backends.api;

import com.leiwang.foodordering.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    Restaurant getRestaurantById(int id);
    List<Restaurant> getAllRestaurant();

}
