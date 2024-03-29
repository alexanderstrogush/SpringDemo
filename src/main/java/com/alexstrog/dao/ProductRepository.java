package com.alexstrog.dao;

import com.alexstrog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<List<Product>> getAllByCategory_Id(Long id);
}
