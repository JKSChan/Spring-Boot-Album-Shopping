package com.jacksonchan.service.impl;

import com.jacksonchan.dao.ProductDao;
import com.jacksonchan.model.Product;
import com.jacksonchan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
