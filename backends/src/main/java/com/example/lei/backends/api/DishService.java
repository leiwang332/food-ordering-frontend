package com.example.lei.backends.api;

import com.leiwang.foodordering.domain.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getRestaurantMenuById(int id);
    byte [] getImageById(int imageId);
}
