package com.springboot.jpa.dto;

import com.springboot.jpa.entitiy.ProductEntity;
import lombok.*;
import org.springframework.lang.Nullable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String productName;
    private int productPrice;
    private int productStock;

    public static ProductEntity toEntity(ProductDTO productDTO){
        return ProductEntity.builder()
                .id(productDTO.getId())
                .productName(productDTO.getProductName())
                .productPrice(productDTO.getProductPrice())
                .productStock(productDTO.getProductStock())
                .build();
    }
}
