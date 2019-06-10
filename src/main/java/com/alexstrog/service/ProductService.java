package com.alexstrog.service;

import com.alexstrog.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<List<Product>> getAllById(Long id);
}
