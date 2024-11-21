package com.jacksonchan.rowmapper;

import com.jacksonchan.constant.ProductAlbumType;
import com.jacksonchan.constant.ProductCategory;
import com.jacksonchan.constant.ProductShelves;
import com.jacksonchan.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getInt("product_id"));
        product.setCategory(ProductCategory.valueOf(resultSet.getString("category")));
        //同上
        //String categoryStr = resultSet.getString("category");
        //ProductCategory category = ProductCategory.valueOf(categoryStr);
        //product.setCategory(category);

        product.setAlbumType(ProductAlbumType.valueOf(resultSet.getString("album_type")));
        product.setSinger(resultSet.getString("singer"));
        product.setProductName(resultSet.getString("product_name"));
        product.setImageUrl(resultSet.getString("image_url"));
        product.setBarcode(resultSet.getString("barcode"));
        product.setCompany(resultSet.getString("company"));
        product.setIssueDate(resultSet.getDate("issue_date"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setShelves(ProductShelves.valueOf(resultSet.getString("shelves")));
        product.setCreatedDate(resultSet.getTimestamp("created_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));

        return product;
    }
}
