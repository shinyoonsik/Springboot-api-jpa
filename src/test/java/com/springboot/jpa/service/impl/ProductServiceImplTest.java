package com.springboot.jpa.service.impl;

import com.springboot.jpa.dto.ProductDTO;
import com.springboot.jpa.entitiy.ProductEntity;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void getProductList() {
        List<ProductDTO> result = productService.getProductList(500);

        assertTrue(result.size() > 1);
    }

    @Test
    void insertProduct(){
        int price = 1000;
        int stock = 1;
        String name = "hello";

        int result = productRepository.insertProduct(price, stock, name);

        System.out.println(result);
    }
}