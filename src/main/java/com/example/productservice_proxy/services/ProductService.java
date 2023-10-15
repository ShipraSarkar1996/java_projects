package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;

public class ProductService implements IProductService {

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
    public String getsSingleProduct(Long product) {
        return "Product retrieved successfully";
    }
    @Override
    public String getAllProducts() {
        return "All products retrieved successfully";
    }

}
