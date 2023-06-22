package com.springboot.jpa.controller;

import com.springboot.jpa.dto.ProductDto;
import com.springboot.jpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public ResponseEntity<ProductDto> getProduct(Long id) throws Exception {
        LOGGER.info("[HTTP Get: getProduct] id: " + id);
        ProductDto productDto = productService.getProduct(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productDto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto requestedProductDto){
        LOGGER.info("[HTTP Post: saveProduct] productDto: " + requestedProductDto);
        ProductDto productDto = productService.saveProduct(requestedProductDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productDto);
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto requestedProductDto){
        LOGGER.info("[HTTP Put: updateProduct] productDto: " + requestedProductDto);
        ProductDto productDto = productService.updateProduct(requestedProductDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productDto);
    }

    @DeleteMapping("/product")
    public ResponseEntity<Boolean> deleteProduct(Long id){
        LOGGER.info("[HTTP Delete] id: " + id);
        boolean result = productService.deleteProduct(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(result);
    }


}
