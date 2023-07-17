package com.springboot.jpa.entitiy;

import com.springboot.jpa.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Long id 필드의 값은 Product 엔티티가 데이터베이스에 저장될 때 자동으로 채워진다.
    private Long id;

    @Column(nullable = true, name = "name")
    private String productName;

    @Column(nullable = true, name = "price")
    private int productPrice;

    @Column(nullable = true, name = "stock")
    private int productStock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static ProductDTO toDto(ProductEntity productEntity){
        return ProductDTO.builder()
                .id(productEntity.getId())
                .productPrice(productEntity.getProductPrice())
                .productStock(productEntity.getProductStock())
                .productName(productEntity.getProductName())
                .build();
    }
}
