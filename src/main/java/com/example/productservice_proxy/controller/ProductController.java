package com.example.productservice_proxy.controller;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.services.IProductService;
import com.example.productservice_proxy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

//    public ProductController(IProductService productService){
//        this.productService = productService;
//    }
    @GetMapping("/products")
    public String getAllProduct(){
        return "Get all products";
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long productId){
        String product = this.productService.getSingleProduct(productId);
        return "Get the product with " + product;
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
