package com.jacksonchan.dto;

import com.jacksonchan.constant.ProductAlbumType;
import com.jacksonchan.constant.ProductCategory;

public class ProductQueryParams {
    private ProductCategory category;
    private ProductAlbumType albumType;
    private String singerSearch;
    private String productNameSearch;
    private String orderBy;
    private String sort;
    private Integer limit;
    private Integer offset;

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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
