package com.example.lei.backends.api;

public interface BackendFactory {
    RestaurantService createResturantService();
    DishService createDishService();
    UserService createUserService();
}
