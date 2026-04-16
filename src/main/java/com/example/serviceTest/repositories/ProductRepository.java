package com.example.serviceTest.repositories;

import com.example.serviceTest.models.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductInfo, Long> {
    List<ProductInfo> findByTitle(String title);
}
