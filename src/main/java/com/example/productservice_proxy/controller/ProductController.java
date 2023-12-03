package com.example.productservice_proxy.controller;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;
import com.example.productservice_proxy.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IProductService productService;

//    public ProductController(IProductService productService){
//        this.productService = productService;
//    }
    @GetMapping("")
    public List<Product> getAllProduct(){
        return this.productService.getAllProducts();

    }

    @GetMapping("/{id}")
    private ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId){
        try{
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Type", "application/json");
            headers.add("Accept", "application/json");
            headers.add("auth-token", "keyaccess");
        Product product = this.productService.getSingleProduct(productId);
        if (productId <1){
        throw new IllegalArgumentException("Invalid product id");}
        ResponseEntity responseEntity = new ResponseEntity<>(product,headers, HttpStatus.OK);
        return  responseEntity;
    }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDto productDto){
        Product product = this.productService.addNewProduct(productDto);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/{productId}")
    public  String updateProduct(@PathVariable("productId") Long productId){
        return "Update the product with productId " + productId;
    }

}
