package com.example.productsearch.api;

import com.example.productsearch.entity.Product;
import com.example.productsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/search/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getList(){
        return ResponseEntity.ok(productService.findAll());
    }
}
