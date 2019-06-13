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
    public Optional<List<Product>> getAllByCategoryId(Long id) {
        return productRepository.getAllByCategory_Id(id);
    }

    @Override
    public Optional<Product> getById(long id) {
        return productRepository.findById(id);
    }

    public Optional<Product> save(Product product) {
        return Optional.of(productRepository.save(product));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> update(Product product) {
        return Optional.of(productRepository.save(product));
    }
}
