package com.example.productservice_proxy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {

    @GetMapping()
    public String getAllCategories(){
        return "Get all categories";
    }

    @GetMapping("/{categoryId}")
    public String getSingleCategory(){
        return "Get this category";
    }

}
