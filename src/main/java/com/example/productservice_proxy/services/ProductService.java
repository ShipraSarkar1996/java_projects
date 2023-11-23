package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
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
    public Product getSingleProduct(Long productId) {
        RestTemplate rest = restTemplate.build();
        ProductDto productDto = rest.getForEntity("https://fakestoreapi.com/products/{id}", ProductDto.class,productId).getBody();
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle((String) productDto.getTitle());
        product.setPrice((Double) productDto.getPrice());
        Categories category = new Categories();
        product.setCategory(category);
        product.setImage( productDto.getImage());
        product.setDescription(productDto.getDescription());

        return product;
    }
    @Override
    public String getAllProducts() {
        return "All products retrieved successfully";
    }

}
