package com.example.productsearch.service;

import com.example.productsearch.entity.Product;
import com.example.productsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRespository) {
        this.productRepository = productRespository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {return productRepository.findById(id);}

    public Product save(Product stock) {return productRepository.save(stock);}
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
