package com.example.productservice_proxy.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
//    private Categories category;
//    private String rating;
}
