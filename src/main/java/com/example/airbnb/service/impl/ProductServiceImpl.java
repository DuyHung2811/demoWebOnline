package com.example.airbnb.service.impl;

import com.example.airbnb.model.Product;
import com.example.airbnb.repository.ProductRepository;
import com.example.airbnb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Product> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Iterable<Product> findAllByPriceBetween(float from, float to) {
        return repository.findAllByPriceBetween(from, to);
    }

    @Override
    public Iterable<Product> findAllByCategoryId(Long id) {
        return repository.findAllByCategoryId(id);
    }


//    @Override
//    public Iterable<Product> findProductByCategoryId(Long id) {
//        return repository.findAllByCategoryId(id);
//    }

//    @Override
//    public Iterable<Product> findAllByPriceBetween(float from, float to) {
//        return repository.findAllByPriceBetween(from, to);
//    }

//    @Override
//    public Iterable<Product> findAllByProductNameContains(String name) {
//        return repository.findAllByProductNameContains(name);
//    }
}
