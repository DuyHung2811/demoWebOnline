package com.example.airbnb.repository;

import com.example.airbnb.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    @Query("select u from  Product  u where u.Id= ?1")
    Optional<Product> findById(Long id);

    @Query("select u from  Product  u where u.ProductName like ?1")
//    @Query(value = "select * from  Product where ProductName like ?1", nativeQuery = true)
    Iterable<Product> findByName(String name);

    @Query("select u from  Product  u where u.Price between :from and :to")
    Iterable<Product> findAllByPriceBetween(float from, float to);

    @Query("select u from Category u where u.id =?1")
    Iterable<Product> findAllByCategoryId(Long id);
}
