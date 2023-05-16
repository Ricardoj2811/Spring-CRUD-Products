package com.exercise.productsapp;

import com.exercise.productsapp.model.Product;
import com.exercise.productsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsappApplication.class, args);
	}

}
