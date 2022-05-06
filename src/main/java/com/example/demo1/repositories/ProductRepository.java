package com.example.demo1.repositories;

import com.example.demo1.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByProductName(String ProductName);

}
