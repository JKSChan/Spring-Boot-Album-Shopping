package com.jacksonchan.dao;

import com.jacksonchan.constant.ProductAlbumType;
import com.jacksonchan.constant.ProductCategory;
import com.jacksonchan.dto.ProductRequest;
import com.jacksonchan.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, ProductAlbumType albumType, String singerSearch, String productNameSearch);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
