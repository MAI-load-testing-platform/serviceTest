package com.example.serviceTest.controllers;

import com.example.serviceTest.models.ProductInfo;
import com.example.serviceTest.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @GetMapping
    public List<ProductInfo> getProducts(@RequestParam(required = false) String title) {
        return productService.getProducts(title);
    }

    @GetMapping("/{id}")
    public ProductInfo getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductInfo createProduct(@RequestBody ProductInfo product) {
        productService.saveProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
