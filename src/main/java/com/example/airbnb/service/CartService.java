package com.example.airbnb.service;

import com.example.airbnb.model.Cart;

import java.util.Optional;

public interface CartService {
    void save(Cart cart);

//    void delete(Cart cart);
    void deleteCart(Long id);

    void deleteAll();

//    Optional<Cart> findById(Long id);

    Cart findById(Long id);
}
