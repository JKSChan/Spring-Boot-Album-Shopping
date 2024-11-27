package com.jacksonchan.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jacksonchan.constant.ProductAlbumType;
import com.jacksonchan.constant.ProductCategory;
import com.jacksonchan.constant.ProductShelves;
import com.jacksonchan.dto.ProductRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    // 查詢商品
    @Test
    public void getProduct_success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products/{productId}", 1);

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.category", equalTo("CHINESE")))
                .andExpect(jsonPath("$.albumType", equalTo("CD")))
                .andExpect(jsonPath("$.singer", equalTo("G.E.M.")))
                .andExpect(jsonPath("$.productName", equalTo("新的心跳 Heartbeat")))
                .andExpect(jsonPath("$.imageUrl", notNullValue()))
                .andExpect(jsonPath("$.barcode", equalTo("0888751395923")))
                .andExpect(jsonPath("$.company", equalTo("SONY MUSIC")))
                .andExpect(jsonPath("$.issueDate", notNullValue()))
                .andExpect(jsonPath("$.description", notNullValue()))
                .andExpect(jsonPath("$.price", notNullValue()))
                .andExpect(jsonPath("$.stock", notNullValue()))
                .andExpect(jsonPath("$.shelves", equalTo("Y")))
                .andExpect(jsonPath("$.createdDate", notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate", notNullValue()));
    }

    @Test
    public void getProduct_notFound() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products/{productId}", 5000);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(404));
    }

    // 創建商品
    @Transactional
    @Test
    public void createProduct_success() throws Exception {
        ProductRequest productRequest = new ProductRequest();

        String dateString = "1978-08-23";
        Date sqlDate = Date.valueOf(dateString);

        productRequest.setCategory(ProductCategory.ENGLISH);
        productRequest.setAlbumType(ProductAlbumType.LP);
        productRequest.setSinger("Kobe Bryant");
        productRequest.setProductName("Lakers");
        productRequest.setImageUrl("http://test.com");
        productRequest.setBarcode("081024");
        productRequest.setCompany("NBA_Music");
        productRequest.setIssueDate(sqlDate);
        productRequest.setDescription("G.O.A.T");
        productRequest.setPrice(24);
        productRequest.setStock(8);
        productRequest.setShelves(ProductShelves.Y);

        String json = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.category", equalTo("ENGLISH")))
                .andExpect(jsonPath("$.albumType", equalTo("LP")))
                .andExpect(jsonPath("$.singer", equalTo("Kobe Bryant")))
                .andExpect(jsonPath("$.productName", equalTo("Lakers")))
                .andExpect(jsonPath("$.imageUrl", equalTo("http://test.com")))
                .andExpect(jsonPath("$.barcode", equalTo("081024")))
                .andExpect(jsonPath("$.company", equalTo("NBA_Music")))
                .andExpect(jsonPath("$.issueDate", equalTo("1978-08-23")))
                .andExpect(jsonPath("$.description", equalTo("G.O.A.T")))
                .andExpect(jsonPath("$.price", equalTo(24)))
                .andExpect(jsonPath("$.stock", equalTo(8)))
                .andExpect(jsonPath("$.shelves", equalTo("Y")))
                .andExpect(jsonPath("$.createdDate", notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate", notNullValue()));
    }

    @Transactional
    @Test
    public void createProduct_illegalArgument() throws Exception {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setSinger("Wiggins");

        String json = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));
    }


    // 更新商品
    @Transactional
    @Test
    public void updateProduct_success() throws Exception {
        ProductRequest productRequest = new ProductRequest();
        String dateString = "1978-08-23";
        Date sqlDate = Date.valueOf(dateString);

        productRequest.setCategory(ProductCategory.ENGLISH);
        productRequest.setAlbumType(ProductAlbumType.LP);
        productRequest.setSinger("Kobe Bryant");
        productRequest.setProductName("Lakers");
        productRequest.setImageUrl("http://test.com");
        productRequest.setBarcode("081024");
        productRequest.setCompany("NBA_Music");
        productRequest.setIssueDate(sqlDate);
        productRequest.setDescription("G.O.A.T");
        productRequest.setPrice(24);
        productRequest.setStock(8);
        productRequest.setShelves(ProductShelves.Y);

        String json = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/products/{productId}", 3)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.category", equalTo("ENGLISH")))
                .andExpect(jsonPath("$.albumType", equalTo("LP")))
                .andExpect(jsonPath("$.singer", equalTo("Kobe Bryant")))
                .andExpect(jsonPath("$.productName", equalTo("Lakers")))
                .andExpect(jsonPath("$.imageUrl", equalTo("http://test.com")))
                .andExpect(jsonPath("$.barcode", equalTo("081024")))
                .andExpect(jsonPath("$.company", equalTo("NBA_Music")))
                .andExpect(jsonPath("$.issueDate", equalTo("1978-08-23")))
                .andExpect(jsonPath("$.description", equalTo("G.O.A.T")))
                .andExpect(jsonPath("$.price", equalTo(24)))
                .andExpect(jsonPath("$.stock", equalTo(8)))
                .andExpect(jsonPath("$.shelves", equalTo("Y")))
                .andExpect(jsonPath("$.createdDate", notNullValue()))
                .andExpect(jsonPath("$.lastModifiedDate", notNullValue()));

    }

    @Transactional
    @Test
    public void updateProduct_illegalArgument() throws Exception {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setSinger("Wiggins");

        String json = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/products/{productId}", 5)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(400));
    }

    @Transactional
    @Test
    public void updateProduct_productNotFound() throws Exception {
        ProductRequest productRequest = new ProductRequest();
        String dateString = "1978-08-23";
        Date sqlDate = Date.valueOf(dateString);

        productRequest.setCategory(ProductCategory.ENGLISH);
        productRequest.setAlbumType(ProductAlbumType.LP);
        productRequest.setSinger("Kobe Bryant");
        productRequest.setProductName("Lakers");
        productRequest.setImageUrl("http://test.com");
        productRequest.setBarcode("081024");
        productRequest.setCompany("NBA_Music");
        productRequest.setIssueDate(sqlDate);
        productRequest.setDescription("G.O.A.T");
        productRequest.setPrice(24);
        productRequest.setStock(8);
        productRequest.setShelves(ProductShelves.Y);

        String json = objectMapper.writeValueAsString(productRequest);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/products/{productId}", 5000)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(404));

    }

    // 刪除商品
    @Transactional
    @Test
    public void deleteProduct_success() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/products/{productId}", 10);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(204));

    }

    @Transactional
    @Test
    public void deleteProduct_deleteNonExistingProduct() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/products/{productId}", 5000);

        mockMvc.perform(requestBuilder)
                .andExpect(status().is(204));
    }

    // 查詢商品列表
    @Test
    public void getProducts() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.limit", notNullValue()))
                .andExpect(jsonPath("$.offset", notNullValue()))
                .andExpect(jsonPath("$.total", notNullValue()))
                .andExpect(jsonPath("$.results", hasSize(4)));
    }

    @Test
    public void getProducts_filtering() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("singerSearch", "織部里沙")
                .param("productNameSearch", "BEST");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.limit", notNullValue()))
                .andExpect(jsonPath("$.offset", notNullValue()))
                .andExpect(jsonPath("$.total", notNullValue()))
                .andExpect(jsonPath("$.results", hasSize(3)));
    }

    @Test
    public void getProducts_sorting() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("orderBy", "stock")
                .param("sort", "desc");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.limit", notNullValue()))
                .andExpect(jsonPath("$.offset", notNullValue()))
                .andExpect(jsonPath("$.total", notNullValue()))
                .andExpect(jsonPath("$.results", hasSize(4)))
                .andExpect(jsonPath("$.results[0].productId", equalTo(13)))
                .andExpect(jsonPath("$.results[1].productId", equalTo(12)))
                .andExpect(jsonPath("$.results[2].productId", equalTo(11)))
                .andExpect(jsonPath("$.results[3].productId", equalTo(4)));
    }

    @Test
    public void getProducts_pagination() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/products")
                .param("limit", "2")
                .param("offset", "5");

        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.limit", notNullValue()))
                .andExpect(jsonPath("$.offset", notNullValue()))
                .andExpect(jsonPath("$.total", notNullValue()))
                .andExpect(jsonPath("$.results", hasSize(2)))
                .andExpect(jsonPath("$.results[0].productId", equalTo(12)))
                .andExpect(jsonPath("$.results[1].productId", equalTo(11)));
    }
}