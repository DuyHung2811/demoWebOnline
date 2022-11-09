package com.example.airbnb.controller;

import com.example.airbnb.model.Product;
import com.example.airbnb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        Iterable<Product> products = productService.findAll();
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("find-by-id/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @GetMapping("find-by-price")
    public ResponseEntity<Iterable<Product>> findByPrice(@RequestParam float from, @RequestParam float to) {
        Iterable<Product> products = productService.findAllByPriceBetween(from, to);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("find-by-name")
    public ResponseEntity<Iterable<Product>> findByName(@RequestParam String name) {
        Iterable<Product> products = productService.findByName(name);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("find-by-category-id/{id}")
    public ResponseEntity<Iterable<Product>> findByCategoryId(@PathVariable Long id) {
        Iterable<Product> products = productService.findAllByCategoryId(id);
        if (products == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
