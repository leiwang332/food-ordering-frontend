package com.example.lei.backends.api;

import com.leiwang.foodordering.domain.User;

public interface UserService {
    User getUserByEmail(String email);
    User createUser(User newUser);
    boolean authenticate(User user);
}
