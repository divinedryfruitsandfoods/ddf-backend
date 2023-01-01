package com.ddf.repository;

import com.ddf.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByProductName(String productName);
}
