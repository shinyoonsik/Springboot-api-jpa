package com.springboot.jpa.service.impl;

import com.springboot.jpa.dto.ProductDTO;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setUp(){
        int price = 1000;
        int stock = 1;
        String name = "hello";

        productRepository.insertProduct(price, stock, name);
    }

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

        assertTrue(result > 1);
    }

    @Test
    void updateProduct(){
        // given
        String name = "하쿠나 마타타!!!";
        int price = 10000;
        int stock = 9090;
        Long id = 1L;

        // when
        int result = productRepository.updateProduct(name, price, stock, id);

        // then
        assertTrue(result > 0);
    }
}