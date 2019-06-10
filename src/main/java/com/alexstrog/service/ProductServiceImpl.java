package com.alexstrog.service;

import com.alexstrog.dao.ProductRepository;
import com.alexstrog.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<List<Product>> getAllById(Long id) {
        Optional<List<Product>> products = productRepository.getAllByCategory_Id(id);
        return productRepository.getAllByCategory_Id(id);
    }
}
