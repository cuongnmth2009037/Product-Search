package com.example.productsearch.search;

import com.example.productsearch.ProductSearchApplication;
import com.example.productsearch.entity.Product;
import com.example.productsearch.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductSearchApplication.class)
class ProductSpecificationTest {
    @Autowired
    ProductRepository productRepository;
    @Test
    public void demoTest(){
        ProductSpecification filter01 =
                new ProductSpecification(new SearchCriteria("name","=","Mr . Jarrod Von"));
        ProductSpecification filter02 =
                new ProductSpecification(new SearchCriteria("price",">=",10000));
        ProductSpecification filter03 =
                new ProductSpecification(new SearchCriteria("price",">=",15000));
        List<Product> products = productRepository.findAll(filter01.and(filter03));
        System.out.println(products.size());
    }
}