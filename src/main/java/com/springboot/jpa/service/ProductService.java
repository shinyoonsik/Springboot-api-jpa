package com.springboot.jpa.service;

import com.springboot.jpa.dto.ProductDto;

public interface ProductService {

    ProductDto getProduct(Long id) throws Exception;

    ProductDto saveProduct(ProductDto productDto);

    ProductDto updateProduct(ProductDto productDto);

    boolean deleteProduct(Long id);

}
