package com.example.productservice_proxy.controller;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId){
        try{
        Product product = this.productService.getSingleProduct(productId);
        if (productId <1){
        throw new IllegalArgumentException("Invalid product id");}
        ResponseEntity responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return  responseEntity;
    }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
