package com.example.productservice_proxy.controller;

import com.example.productservice_proxy.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("")
    public String getAllProduct(){
        return "Get all products";
    }

    @GetMapping("/{productId}")
    public String getSingleProduct(@PathVariable("productId") Long productId){
        return "Get this product with the product Id " + productId;
    }

    @PostMapping()
    public String addNewProduct(@RequestBody ProductDto productDto){
        return "Add new product " + productDto;
    }

    @PatchMapping("/{productId}")
    public  String updateProduct(@PathVariable("productId") Long productId){
        return "Update the product with productId " + productId;
    }
}
