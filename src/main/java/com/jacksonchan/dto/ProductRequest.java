package com.jacksonchan.dto;

import com.jacksonchan.constant.ProductAlbumType;
import com.jacksonchan.constant.ProductCategory;
import com.jacksonchan.constant.ProductShelves;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductRequest {
    @NotNull
    private ProductCategory category;
    @NotNull
    private ProductAlbumType albumType;
    @NotNull
    private String singer;
    @NotNull
    private String productName;
    @NotNull
    private String imageUrl;
    @NotNull
    private String barcode;
    @NotNull
    private String company;
    @NotNull
    private Date issueDate;
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Integer stock;
    @NotNull
    private ProductShelves shelves;

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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ProductShelves getShelves() {
        return shelves;
    }

    public void setShelves(ProductShelves shelves) {
        this.shelves = shelves;
    }
}
