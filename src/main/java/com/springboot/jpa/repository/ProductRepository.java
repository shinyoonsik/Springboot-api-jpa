package com.springboot.jpa.repository;

import com.springboot.jpa.entitiy.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> { // Repository가 사용할 entitiy: ProductEntity, ProductEntity의 타입
    ProductEntity findByProductName(String name);
}
