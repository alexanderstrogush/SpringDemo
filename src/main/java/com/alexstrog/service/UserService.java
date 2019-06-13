package com.alexstrog.service;

import com.alexstrog.controller.UserController;
import com.alexstrog.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> add(User user);

    Optional<List<User>> getAll();

    Optional<User> getById(Long id);
}
