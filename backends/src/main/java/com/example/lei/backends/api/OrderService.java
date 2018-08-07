package com.example.lei.backends.api;

import com.leiwang.foodordering.domain.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getOrdersByUserId(int userId);
}
