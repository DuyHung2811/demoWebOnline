package com.example.airbnb.service;

import com.example.airbnb.model.Product;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);

    Iterable<Product> findByName(String name);

    Iterable<Product> findAllByPriceBetween(float from, float to);

    Iterable<Product> findAllByCategoryId(Long id);

}
