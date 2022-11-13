package com.example.airbnb.controller;

import com.example.airbnb.model.Cart;
import com.example.airbnb.model.Product;
import com.example.airbnb.service.CartService;
import com.example.airbnb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PutMapping
    public ResponseEntity save(@RequestBody Cart cart) {
        cartService.save(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @DeleteMapping()
//    public ResponseEntity delete(@RequestBody Cart cart) {
//        cartService.delete(cart);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity deleteAll() {
        cartService.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity edit(@RequestBody Cart cart, @PathVariable Long id) {
//        Optional<Cart> cart1 = cartService.findById(id);
//        if(!cart1.isPresent()){
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        cart.setId(id);
//        cartService.save(cart);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    @PutMapping("/change-status")
    public ResponseEntity changeStatus(@RequestParam Long id) {
        Cart carts = cartService.findById(id);
            carts.setStatus(1);
            cartService.save(carts);
        return new ResponseEntity(HttpStatus.OK);
    }


}
