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


    static final String INSERT_PRODUCT = "INSERT INTO product (price, stock, name) VALUES (:price, :stock, :name)";
    static final String UPDATE_PRODUCT = "UPDATE product p SET p.name = :name, p.price = :price, p.stock = :stock WHERE p.id = :id";

    @Modifying
    @Query(value = INSERT_PRODUCT, nativeQuery = true)
    @Transactional
    int insertProduct(@Param("price") int price, @Param("stock") int stock, @Param("name")String name);


    @Modifying
    @Query(value = UPDATE_PRODUCT, nativeQuery = true)
    @Transactional
    int updateProduct(String name, int price, int stock, @Param("id") Long id);

}
