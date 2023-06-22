package com.springboot.jpa.service.impl;

import com.springboot.jpa.dto.ProductDto;
import com.springboot.jpa.entitiy.Product;
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
class ProductServiceImplTest {

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

        ProductDto productDto = new ProductDto(null, PRODUCT_NAME, PRODUCT_PIRCE, PRODUCT_STOCK);
        productService.saveProduct(productDto);
    }

    @Test
    void saveProduct() {
        // given
        ProductDto productDto = new ProductDto(null, "헬로", PRODUCT_PIRCE, PRODUCT_STOCK);

        // when
        ProductDto result = productService.saveProduct(productDto);

        // then
        assertEquals("헬로", result.getName());
    }

    @Test
    void getProduct() throws Exception {
        // given
        Product product = productRepository.findByName(PRODUCT_NAME);
        Long id = product.getId();

        // when
        ProductDto result = productService.getProduct(id);

        // then
        assertEquals( PRODUCT_PIRCE, result.getPrice());
    }

    @Test
    void updateProduct() throws Exception{
        // given
        Product product = productRepository.findByName(PRODUCT_NAME);
        Long id = product.getId();

        int priceToUpdate = 2323;
        String nameToUpdate = "솜방망이";
        ProductDto productDto = new ProductDto(id, nameToUpdate, priceToUpdate, PRODUCT_STOCK);

        // when
        ProductDto result = productService.updateProduct(productDto);

        // then
        assertThat(result)
                .isEqualTo(productDto);
    }

    @Test
    void deleteProduct() throws Exception{
        // given
        Product product = productRepository.findByName(PRODUCT_NAME);
        Long id = product.getId();

        // when
        boolean result = productService.deleteProduct(id);

        // then
        assertThat(result).isTrue();
    }

}