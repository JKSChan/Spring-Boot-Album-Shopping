package com.jacksonchan.service;

import com.jacksonchan.dto.ProductRequest;
import com.jacksonchan.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
