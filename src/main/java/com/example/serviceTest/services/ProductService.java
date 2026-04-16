package com.example.serviceTest.services;

import com.example.serviceTest.models.ProductInfo;
import com.example.serviceTest.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
   private final ProductRepository productRepository;

    public List<ProductInfo> getProducts(String title)
    {
        if(title != null ) return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public void saveProduct(ProductInfo product) {
        log.info("Saving product : {}", product);
        productRepository.save(product);
    }
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    public ProductInfo getProductById(Long id) {
       return productRepository.findById(id).orElse(null);
    }
}
