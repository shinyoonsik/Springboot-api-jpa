package com.springboot.jpa.service.impl;

import com.springboot.jpa.dto.ProductDTO;
import com.springboot.jpa.entitiy.ProductEntity;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    // Spring은 Bean을 기본적으로 싱글톤으로 관리한다. 따라서 하나의 객체를 여러 곳에서 사용한다.
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProduct(Long id) throws Exception {
        LOGGER.info("[method: getProduct] 매개변수 id: {}", id);
        Objects.requireNonNull(id, "id should not be null");

        ProductEntity selectedProductEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id: " + id));
        LOGGER.info("[method: getProduct] selected Product: {}", selectedProductEntity);

        return ProductEntity.toDto(selectedProductEntity);
    }

    @Override
    public ProductDTO saveProduct(ProductDTO productDto) {
        LOGGER.info("[method: saveProduct] 매개변수 productDto: {}", productDto);
        Objects.requireNonNull(productDto, "product should not be null");

        ProductEntity productEntity = ProductDTO.toEntity(productDto);
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        LOGGER.info("[method: saveProduct] 저장된 product: {}", savedProductEntity);

        return ProductEntity.toDto(savedProductEntity);
    }

//    @Override
//    public ProductDTO updateProduct(ProductDTO productDto) {
//        LOGGER.info("[method: updateProduct] 매개변수: {}", productDto);
//        Objects.requireNonNull(productDto, "product should not be null");
//        Objects.requireNonNull(productDto.getId(), "product's id should not be null");
//
//        ProductEntity productEntity = productRepository.findById(productDto.getId()).orElseThrow(() -> new RuntimeException("product not found with id: " + productDto.getId()));
//        if(productDto.getName() == null && productDto.getName().isBlank()) throw new RuntimeException("product name should not be null or empty");
//        if(productDto.getPrice() < 0) throw new RuntimeException("price should not be negative");
//        if(productDto.getStock() < 0) throw new RuntimeException("stock should not be negative");
//
//        productEntity.setName(productDto.getName());
//        productEntity.setPrice(productDto.getPrice());
//        productEntity.setStock(productDto.getStock());
//        productEntity.setUpdatedAt(LocalDateTime.now());
//        LOGGER.info("[updateProduct] 업데이트된 product: {}", productEntity);
//
//        ProductEntity savedProductEntity = productRepository.save(productEntity);
//
//        return ProductDTO.of(savedProductEntity);
//    }
//
//    @Override
//    public boolean deleteProduct(Long id) {
//        LOGGER.info("[method: deleteProduct] 매개변수 id: {}", id);
//        Objects.requireNonNull(id, "id should not be null");
//        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new RuntimeException("product not found with id: " + id));
//
//        try{
//            productRepository.deleteById(productEntity.getId());
//        }catch (Exception e){
//            throw new RuntimeException("product was not deleted");
//        }
//
//        return true;
//    }
}
