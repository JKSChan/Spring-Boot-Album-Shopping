package com.jacksonchan.dao;

import com.jacksonchan.dto.ProductRequest;
import com.jacksonchan.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

}
