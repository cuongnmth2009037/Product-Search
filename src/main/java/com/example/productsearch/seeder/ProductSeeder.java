package com.example.productsearch.seeder;

import com.example.productsearch.entity.Product;
import com.example.productsearch.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Component
public class ProductSeeder implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;
    private static final int numberOfProducts = 10000;

    public void generate(){
        Faker faker = new Faker();
        String[] size = {"X","M","L","S","XL","XS"};
        String[] gender = {"Male","FeMale","Other"};
        String[] color = {"Red","Yellow","Blue","Black","Pink"};
        int colorIndex = color.length;
        int sizeIndex = size.length;
        int genderIndex = gender.length;
        int maxPrice = 20000;
        int minPrice = 1000;

        Random random = new Random();
        int pickColor = random.nextInt(colorIndex);
        int pickSize = random.nextInt(sizeIndex);
        int pickGender = random.nextInt(genderIndex);

        String colorPicker = color[pickColor];
        String sizePicker = size[pickSize];
        String genderPicker = gender[pickGender];
        List<Product> products =new ArrayList<>();
        for (int i = 0; i < numberOfProducts; i++) {
            products.add(Product.builder()
                    .name(faker.name().title())
                    .description(faker.name().title())
                    .gender(genderPicker)
                    .color(colorPicker)
                    .size(sizePicker)
                    .price(faker.number().numberBetween(minPrice, maxPrice))
                    .status(faker.number().numberBetween(1,2))
                    .build()
            );
        }
        productRepository.saveAll(products);
    }

    @Override
    public void run(String... args) throws Exception {
        generate();
    }
}
