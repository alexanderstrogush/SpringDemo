package com.alexstrog.service;

import com.alexstrog.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<List<Category>> getAll();

    Optional<Category> create(Category category);

    Optional<Category> getById(Long id);

    Optional<Category> update(Category category);

    void delete(Long id);
}
