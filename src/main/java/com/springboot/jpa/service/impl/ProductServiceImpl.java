package com.springboot.jpa.service.impl;

import com.springboot.jpa.dto.ProductDto;
import com.springboot.jpa.entitiy.Product;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto getProduct(Long id) throws Exception {
        LOGGER.info("[method: getProduct] 매개변수 id: {}", id);
        Objects.requireNonNull(id, "id should not be null");

        Product selectedProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id: " + id));
        LOGGER.info("[method: getProduct] selected Product: {}", selectedProduct);

        return ProductDto.of(selectedProduct);
    }

    @Override
    public ProductDto saveProduct(ProductDto productDto) {
        LOGGER.info("[method: saveProduct] 매개변수 productDto: {}", productDto);
        Objects.requireNonNull(productDto, "product should not be null");

        Product product = Product.of(productDto);
        Product savedProduct = productRepository.save(product);
        LOGGER.info("[method: saveProduct] 저장된 product: {}", savedProduct);

        return ProductDto.of(savedProduct);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto) {
        LOGGER.info("[method: updateProduct] 매개변수: {}", productDto);
        Objects.requireNonNull(productDto, "product should not be null");
        Objects.requireNonNull(productDto.getId(), "product's id should not be null");

        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new RuntimeException("product not found with id: " + productDto.getId()));
        if(productDto.getName() == null && productDto.getName().isBlank()) throw new RuntimeException("product name should not be null or empty");
        if(productDto.getPrice() < 0) throw new RuntimeException("price should not be negative");
        if(productDto.getStock() < 0) throw new RuntimeException("stock should not be negative");

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(productDto.getStock());
        product.setUpdatedAt(LocalDateTime.now());
        LOGGER.info("[updateProduct] 업데이트된 product: {}", product);

        Product savedProduct = productRepository.save(product);

        return ProductDto.of(savedProduct);
    }

    @Override
    public boolean deleteProduct(Long id) {
        LOGGER.info("[method: deleteProduct] 매개변수 id: {}", id);
        Objects.requireNonNull(id, "id should not be null");
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id: " + id));

        try{
            productRepository.deleteById(product.getId());
        }catch (Exception e){
            throw new RuntimeException("product was not deleted");
        }

        return true;
    }
}
