package com.example.productservice_proxy.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDto {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
//
//    private String rating;
}
