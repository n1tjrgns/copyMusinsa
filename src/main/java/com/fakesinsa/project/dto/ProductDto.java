package com.fakesinsa.project.dto;

import lombok.Data;

@Data
public class ProductDto {
    private int productId;
    private String productCategory;
    private String productName;
    private int productPrice;
    private String productDetail;
}
