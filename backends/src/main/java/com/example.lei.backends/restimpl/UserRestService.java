package com.example.lei.backends.restimpl;

import com.example.lei.backends.api.UserService;
import com.leiwang.foodordering.domain.User;
import org.springframework.web.client.RestTemplate;

public class UserRestService implements UserService {
    RestTemplate restTemplate = new RestTemplate();
    private static final String URI = "http://10.0.0.2:8080";

    @Override
    public User getUserByEmail(String email) {
        return restTemplate.getForObject(URI + "/get", User.class, email);
    }

    @Override
    public User createUser(User newUser) {
        return restTemplate.postForObject(URI + "/register", newUser, User.class);
    }

    @Override
    public boolean authenticate(User user) {
        return restTemplate.postForObject(URI + "/login", user, Boolean.class);
    }
}
