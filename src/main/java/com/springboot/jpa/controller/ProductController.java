package com.springboot.jpa.controller;

import com.springboot.jpa.dto.ProductDTO;
import com.springboot.jpa.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) throws Exception {
        LOGGER.info("[HTTP Get: getProduct] id: " + id);
        ProductDTO productDto = productService.getProduct(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productDto);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO requestedProductDTO){
        LOGGER.info("[HTTP Post: saveProduct] productDto: " + requestedProductDTO);
        ProductDTO productDto = productService.saveProduct(requestedProductDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productDto);
    }

//    @PutMapping
//    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO requestedProductDTO){
//        LOGGER.info("[HTTP Put: updateProduct] productDto: " + requestedProductDTO);
//        ProductDTO productDto = productService.updateProduct(requestedProductDTO);
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(productDto);
//    }
//
//    @DeleteMapping
//    public ResponseEntity<Boolean> deleteProduct(Long id){
//        LOGGER.info("[HTTP Delete] id: " + id);
//        boolean result = productService.deleteProduct(id);
//
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(result);
//    }


}
