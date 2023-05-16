package com.exercise.productsapp.repository;

import com.exercise.productsapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products p ORDER BY p.precio", nativeQuery = true)
    List<Product> findAllOrderByPrecio();

}
