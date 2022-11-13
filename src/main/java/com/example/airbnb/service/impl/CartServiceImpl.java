package com.example.airbnb.service.impl;

import com.example.airbnb.model.Cart;
import com.example.airbnb.repository.CartRepository;
import com.example.airbnb.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository repository;


    @Override
    public void save(Cart cart) {
        repository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();;
    }

    @Override
    public Cart findById(Long id) {
        return repository.findById(id).get();
    }


}
