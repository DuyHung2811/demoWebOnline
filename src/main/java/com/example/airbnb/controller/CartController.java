package com.example.airbnb.controller;

import com.example.airbnb.model.Cart;
import com.example.airbnb.model.Product;
import com.example.airbnb.service.CartService;
import com.example.airbnb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity save(Cart cart) {
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
