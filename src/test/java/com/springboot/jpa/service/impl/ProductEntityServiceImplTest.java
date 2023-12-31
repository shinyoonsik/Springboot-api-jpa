package com.springboot.jpa.service.impl;

import com.springboot.jpa.dto.ProductDTO;
import com.springboot.jpa.entitiy.ProductEntity;
import com.springboot.jpa.repository.ProductRepository;
import com.springboot.jpa.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import({ProductServiceImpl.class})
class ProductEntityServiceImplTest {

    private final int PRODUCT_PIRCE = 1000;
    private final int PRODUCT_STOCK = 10;
    private final String PRODUCT_NAME = "공책";


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @BeforeEach
    void setUp(TestInfo testInfo){
        if("saveProduct".equals(testInfo.getTestMethod().orElseThrow().getName())) return;

        ProductDTO productDto = new ProductDTO(null, PRODUCT_NAME, PRODUCT_PIRCE, PRODUCT_STOCK);
        productService.saveProduct(productDto);
    }

    @Test
    void saveProduct() {
        // given
        ProductDTO productDto = new ProductDTO(null, "헬로", PRODUCT_PIRCE, PRODUCT_STOCK);

        // when
        ProductDTO result = productService.saveProduct(productDto);

        // then
    }

    @Test
    void getProduct() throws Exception {
//        // given
//        ProductEntity productEntity = productRepository.findByName(PRODUCT_NAME);
//        Long id = productEntity.getId();
//
//        // when
//        ProductDTO result = productService.getProduct(id);
//
//        // then
//        assertEquals( PRODUCT_PIRCE, result.getPrice());
    }

    @Test
    void updateProduct() throws Exception{
//        // given
//        ProductEntity productEntity = productRepository.findByName(PRODUCT_NAME);
//        Long id = productEntity.getId();
//
//        int priceToUpdate = 2323;
//        String nameToUpdate = "솜방망이";
//        ProductDTO productDto = new ProductDTO(id, nameToUpdate, priceToUpdate, PRODUCT_STOCK);
//
//        // when
//        ProductDTO result = productService.updateProduct(productDto);
//
//        // then
//        assertThat(result)
//                .isEqualTo(productDto);
    }

    @Test
    void deleteProduct() throws Exception{
//        // given
//        ProductEntity productEntity = productRepository.findByName(PRODUCT_NAME);
//        Long id = productEntity.getId();
//
//        // when
//        boolean result = productService.deleteProduct(id);
//
//        // then
//        assertThat(result).isTrue();
    }

}