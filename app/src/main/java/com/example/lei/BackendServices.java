package com.example.lei;

import com.example.lei.backends.api.BackendFactory;
import com.example.lei.backends.api.DishService;
import com.example.lei.backends.api.RestaurantService;
import com.example.lei.backends.api.UserService;
import com.example.lei.backends.restimpl.BackendRestFactory;
import com.example.lei.mockimpl.BackendMockFactory;

public final class BackendServices {
    private static RestaurantService _restaurantService;
    private static DishService _dishService;
    private static UserService _userService;

    // ... ...

    private static BackendFactory _mockBackendFactory;
    private static BackendFactory _restBackendFactory;

    static {
        _mockBackendFactory = new BackendMockFactory();
        _restBackendFactory = new BackendRestFactory();

        // Use mock based
        _restaurantService = _mockBackendFactory.createResturantService();
        _dishService = _mockBackendFactory.createDishService();

        // Use REST-based
        _userService = _restBackendFactory.createUserService();
    }

    public static RestaurantService getRestaurantService() {
        return _restaurantService;
    }

    public static DishService getDishService() {
        return _dishService;
    }

    public static UserService get_userService() {
        return _userService;
    }
}
