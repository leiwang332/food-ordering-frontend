package com.example.lei.mockimpl;

import android.content.Context;

import com.example.lei.backends.api.BackendFactory;
import com.example.lei.backends.api.DishService;
import com.example.lei.backends.api.RestaurantService;
import com.example.lei.backends.api.UserService;

public class BackendMockFactory implements BackendFactory {
    private static Context applicationContext;

    @Override
    public RestaurantService createResturantService() {
        return new RestaurantMockService();
    }

    @Override
    public DishService createDishService() {
        return new DishMockService();
    }

    @Override
    public UserService createUserService() {
        return null;
    }

    public static Context getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(Context applicationContext) {
        BackendMockFactory.applicationContext = applicationContext;
    }
}
