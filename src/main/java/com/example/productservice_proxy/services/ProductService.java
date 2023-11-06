package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ProductService implements IProductService {

    private RestTemplateBuilder restTemplate;
    public ProductService(RestTemplateBuilder restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public String addNewProduct(ProductDto product) {
        return "Product added successfully";
    }
    @Override
    public String updateProduct(Long product) {
        return "Product updated successfully";
    }
    @Override
    public String deleteProduct(Long product) {
        return "Product deleted successfully";
    }
    @Override
    public String getSingleProduct(Long productId) {
        RestTemplate rest = restTemplate.build();
        ProductDto productDto = rest.getForEntity("'https://fakestoreapi.com/products/{id}", ProductDto.class,productId).getBody();
        return productDto.toString();
    }
    @Override
    public String getAllProducts() {
        return "All products retrieved successfully";
    }

}
