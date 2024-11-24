package com.jacksonchan.service.impl;

import com.jacksonchan.constant.ProductAlbumType;
import com.jacksonchan.constant.ProductCategory;
import com.jacksonchan.dao.ProductDao;
import com.jacksonchan.dto.ProductRequest;
import com.jacksonchan.model.Product;
import com.jacksonchan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts(ProductCategory category, ProductAlbumType albumType, String singerSearch, String productNameSearch) {
        return productDao.getProducts(category, albumType, singerSearch, productNameSearch);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
