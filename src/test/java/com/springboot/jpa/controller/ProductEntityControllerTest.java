package com.springboot.jpa.controller;

import com.springboot.jpa.dto.ProductDTO;
import com.springboot.jpa.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductEntityControllerTest {

    private final String URL = "/api/v1/product/";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getProduct() throws Exception {
        // given
        Long id = 321L;
        ProductDTO productDto = new ProductDTO(id, "책", 9090, 9);
        given(productService.getProduct(id)).willReturn(productDto);

        // when
        mockMvc.perform(get(URL + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.price").exists())
                .andDo(log());

        // then
        verify(productService).getProduct(id);
    }

    @Test
    void saveProduct() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void deleteProduct() {
    }
}