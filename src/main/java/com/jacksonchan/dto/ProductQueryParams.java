package com.jacksonchan.dto;

import com.jacksonchan.constant.ProductAlbumType;
import com.jacksonchan.constant.ProductCategory;

public class ProductQueryParams {
    private ProductCategory category;
    private ProductAlbumType albumType;
    private String singerSearch;
    private String productNameSearch;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public ProductAlbumType getAlbumType() {
        return albumType;
    }

    public void setAlbumType(ProductAlbumType albumType) {
        this.albumType = albumType;
    }

    public String getSingerSearch() {
        return singerSearch;
    }

    public void setSingerSearch(String singerSearch) {
        this.singerSearch = singerSearch;
    }

    public String getProductNameSearch() {
        return productNameSearch;
    }

    public void setProductNameSearch(String productNameSearch) {
        this.productNameSearch = productNameSearch;
    }
}
