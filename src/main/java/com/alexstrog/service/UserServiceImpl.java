package com.alexstrog.service;

import com.alexstrog.dao.UserRepository;
import com.alexstrog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> add(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<List<User>> getAll() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
}
