package com.springboot.jpa.repository;

import com.springboot.jpa.entitiy.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> { // <Repository가 사용할 entitiy: ProductEntity, ProductEntity의 PK 타입>
    ProductEntity findByProductName(String name);
    List<ProductEntity> findByProductPriceGreaterThan(int productPrice);


    static final String INSERT_PRODUCT = "INSERT INTO product (productPrice, productStock, productName) VALUES (:price, :stock, :name)";

    @Modifying
    @Query(value = INSERT_PRODUCT, nativeQuery = true)
    @Transactional
    int insertProduct(@Param("price") int price, @Param("stock") int stock, @Param("name")String name);


//    @Modifying
//    @Query("INSERT INTO Product (productPrice, productStock) VALUES (:productPrice, :productStock)")
//    void insertProduct(@Param("productPrice") String name, @Param("productStock") int price);



}
