package com.springboot.jpa.dto;

import com.springboot.jpa.entitiy.Product;
import lombok.*;
import org.springframework.lang.Nullable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    @Nullable
    private Long id;

    @Nullable
    private String name;

    private int price;

    private int stock;

    public static ProductDto of(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
