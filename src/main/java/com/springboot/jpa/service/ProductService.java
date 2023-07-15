package com.springboot.jpa.service;

import com.springboot.jpa.dto.ProductDTO;

public interface ProductService {

    ProductDTO getProduct(Long id) throws Exception;

    ProductDTO saveProduct(ProductDTO productDto);

//    ProductDTO updateProduct(ProductDTO productDto);
//
//    boolean deleteProduct(Long id);

}
