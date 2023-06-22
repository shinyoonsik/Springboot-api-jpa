package com.springboot.jpa.entitiy;

import com.springboot.jpa.dto.ProductDto;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Long id 필드의 값은 Product 엔티티가 데이터베이스에 저장될 때 자동으로 채워진다.
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    private int stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static Product of(ProductDto productDto){
        return Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .stock(productDto.getStock())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
