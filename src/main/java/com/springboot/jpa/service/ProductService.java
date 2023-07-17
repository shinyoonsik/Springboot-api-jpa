package com.springboot.jpa.service;

import com.springboot.jpa.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    ProductDTO getProduct(Long id) throws Exception;

    ProductDTO saveProduct(ProductDTO productDto);

    List<ProductDTO> getProductList(int price);

//    ProductDTO updateProduct(ProductDTO productDto);
//
//    boolean deleteProduct(Long id);

}
