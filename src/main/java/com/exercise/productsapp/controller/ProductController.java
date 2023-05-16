package com.exercise.productsapp.controller;

import com.exercise.productsapp.exception.ResourceNotFoundException;
import com.exercise.productsapp.model.Product;
import com.exercise.productsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/create/product")
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not exist with id " + id));
        return ResponseEntity.ok(product);
    }

    @GetMapping("/products/orderByPrice")
    public List<Product> getAllProductsOrderByPrice(){
        return productRepository.findAllOrderByPrecio();
    }

    @PutMapping("/update/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails){
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not exist with id " + id));

        updateProduct.setNombre(productDetails.getNombre());
        updateProduct.setPrecio(productDetails.getPrecio());
        updateProduct.setDescripcion(productDetails.getDescripcion());
        updateProduct.setCantidad(productDetails.getCantidad());

        productRepository.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not exist with id " + id));
        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
