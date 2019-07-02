package com.example.hello.hello.service;

import com.example.hello.hello.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}