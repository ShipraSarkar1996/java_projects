package com.example.productservice_proxy.models;

import com.example.productservice_proxy.dtos.RatingDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private long id;
    private String title;
    private double price;
    private Categories category;
    private String description;
    private String image;
    private RatingDto rating;
}
