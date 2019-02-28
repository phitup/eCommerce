package com.example.ecommerceapp.Objects;

public class Products {
    String productName;
    String productDetail;
    String productPrice;
    String productImage;
    String productCategory;

    public Products() {
    }

    public Products(String productName, String productDetail, String productPrice, String productImage, String productCategory) {
        this.productName = productName;
        this.productDetail = productDetail;
        this.productPrice = productPrice;
        this.productImage = productImage;
        this.productCategory = productCategory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
