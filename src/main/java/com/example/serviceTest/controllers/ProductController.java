package com.example.serviceTest.controllers;

import com.example.serviceTest.models.ProductInfo;
import com.example.serviceTest.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;




    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false)String title,  Model model){
        // --- ИСКУССТВЕННАЯ ДЕГРАДАЦИЯ ---
        // CPU
//        int n = 20000;
//        java.math.BigInteger result = java.math.BigInteger.ONE;
//
//        for (int i = 1; i <= n; i++) {
//            result = result.multiply(java.math.BigInteger.valueOf(i));
//        }
//
//        try {
//            Thread.sleep(200); // 200 мс задержка
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
        // --------------------------------
        model.addAttribute("products", productService.getProducts(title));
        return "products";
    }


    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    @PostMapping("/product/create")
    public String createProduct(ProductInfo product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "redirect:/";
    }


}


