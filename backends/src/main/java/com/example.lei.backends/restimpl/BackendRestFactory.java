package com.example.lei.backends.restimpl;

import com.example.lei.backends.api.BackendFactory;
import com.example.lei.backends.api.DishService;
import com.example.lei.backends.api.RestaurantService;
import com.example.lei.backends.api.UserService;

public class BackendRestFactory implements BackendFactory {
    @Override
    public RestaurantService createResturantService() {
        return null;
    }

    @Override
    public DishService createDishService() {
        return null;
    }

    @Override
    public UserService createUserService() {
        return new UserRestService();
    }
}

