package com.jacksonchan.dao.impl;

import com.jacksonchan.dao.ProductDao;
import com.jacksonchan.dto.ProductQueryParams;
import com.jacksonchan.dto.ProductRequest;
import com.jacksonchan.model.Product;
import com.jacksonchan.rowmapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        String sql = "SELECT product_id,category,album_type,singer,product_name,image_url,barcode,company," +
                "issue_date,description,price,stock,shelves,created_date,last_modified_date " +
                "FROM product WHERE 1=1 ";

        Map<String, Object> map = new HashMap<>();

        if (productQueryParams.getCategory() != null) {
            sql = sql + "AND category = :category ";
            map.put("category", productQueryParams.getCategory().name());
        }

        if (productQueryParams.getAlbumType() != null) {
            sql = sql + "AND album_type = :albumType ";
            map.put("albumType", productQueryParams.getAlbumType().name());
        }

        if (productQueryParams.getSingerSearch() != null) {
            sql = sql + "AND singer LIKE :singerSearch ";
            map.put("singerSearch", "%" + productQueryParams.getSingerSearch() + "%");
        }

        if (productQueryParams.getProductNameSearch() != null) {
            sql = sql + "AND product_name LIKE :productNameSearch ";
            map.put("productNameSearch", "%" + productQueryParams.getProductNameSearch() + "%");
        }

        List<Product> productsList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        return productsList;
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id,category,album_type,singer,product_name,image_url,barcode,company," +
                "issue_date,description,price,stock,shelves,created_date,last_modified_date " +
                "FROM product " +
                "WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if (productList.size() > 0) {
            return productList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        String sql = "INSERT INTO product(category,album_type,singer,product_name,image_url,barcode,company," +
                "issue_date,description,price,stock,shelves,created_date,last_modified_date) " +
                "VALUES (:category, :albumType, :singer, :productName, :imageUrl, :barcode, :company, :issueDate, :description, " +
                ":price, :stock, :shelves, :createdDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("category", productRequest.getCategory().toString());
        map.put("albumType", productRequest.getAlbumType().toString());
        map.put("singer", productRequest.getSinger());
        map.put("productName", productRequest.getProductName());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("barcode", productRequest.getBarcode());
        map.put("company", productRequest.getCompany());
        map.put("issueDate", productRequest.getIssueDate());
        map.put("description", productRequest.getDescription());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("shelves", productRequest.getShelves().toString());

        Date now = new Date();
        map.put("createdDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET category = :category, album_type = :albumType, singer = :singer, product_name = :productName, " +
                "image_url = :imageUrl, barcode = :barcode, company = :company, issue_date = :issueDate, description = :description, " +
                "price = :price, stock = :stock, shelves = :shelves, last_modified_date = :lastModifiedDate " +
                "WHERE product_id = :productId ";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        map.put("category", productRequest.getCategory().toString());
        map.put("albumType", productRequest.getAlbumType().toString());
        map.put("singer", productRequest.getSinger());
        map.put("productName", productRequest.getProductName());
        map.put("imageUrl", productRequest.getImageUrl());
        map.put("barcode", productRequest.getBarcode());
        map.put("company", productRequest.getCompany());
        map.put("issueDate", productRequest.getIssueDate());
        map.put("description", productRequest.getDescription());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("shelves", productRequest.getShelves().toString());

        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId ";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
