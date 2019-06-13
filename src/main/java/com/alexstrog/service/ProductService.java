package com.alexstrog.service;

import com.alexstrog.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<List<Product>> getAllByCategoryId(Long id);

    Optional<Product> getById(long id);

    Optional<Product> save(Product product);

    void deleteById(Long id);

    Optional<Product> update(Product product);
}
