package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;

public interface IProductService {
    String addNewProduct(ProductDto product);

    String updateProduct(Long product);

    String deleteProduct(Long product);

    Product getSingleProduct(Long product);



    String getAllProducts();
}
