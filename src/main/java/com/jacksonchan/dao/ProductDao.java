package com.jacksonchan.dao;

import com.jacksonchan.dto.ProductQueryParams;
import com.jacksonchan.dto.ProductRequest;
import com.jacksonchan.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
