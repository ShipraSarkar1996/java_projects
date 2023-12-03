package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Categories;
import com.example.productservice_proxy.models.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service

public class ProductService implements IProductService {

    private RestTemplateBuilder restTemplate;
    public ProductService(RestTemplateBuilder restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product addNewProduct(ProductDto product) {

        RestTemplate rest = restTemplate.build();
        rest.postForEntity("https://fakestoreapi.com/products",product,ProductDto.class);
        Product pro = getProduct(product);
        return pro;
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
        Product product = getProduct(productDto);
        return product;
    }


    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate1 = restTemplate.build();
        ResponseEntity<ProductDto[]> productDtos =
                restTemplate1.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);

        List<Product> answer = new ArrayList<>();

        for(ProductDto productDto: productDtos.getBody()){
            Product product = new Product();
            product.setId(productDto.getId());
            product.setTitle( productDto.getTitle());
            product.setPrice( productDto.getPrice());
            Categories category = new Categories();
            product.setCategory(category);
            product.setImage( productDto.getImage());
        //    product.setDescription(productDto.getDescription());
            answer.add(product);
        }
        return answer;
    }

    private Product getProduct(ProductDto productDto) {
        Product pro = new Product();
        pro.setId(productDto.getId());
        pro.setTitle((String) productDto.getTitle());
        pro.setPrice((Double) productDto.getPrice());
        Categories category = new Categories();
        pro.setCategory(category);
        pro.setImage( productDto.getImage());
        pro.setDescription(productDto.getDescription());

        return pro;
    }
}
