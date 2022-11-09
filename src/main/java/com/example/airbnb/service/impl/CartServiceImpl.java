package com.example.airbnb.service.impl;

import com.example.airbnb.model.Cart;
import com.example.airbnb.repository.CartRepository;
import com.example.airbnb.repository.ProductRepository;
import com.example.airbnb.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository repository;


    @Override
    public void save(Cart cart) {
        repository.save(cart);
    }
}
