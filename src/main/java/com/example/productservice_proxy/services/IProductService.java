package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;

public interface IProductService {
    String addNewProduct(ProductDto product);

    String updateProduct(Long product);

    String deleteProduct(Long product);

    String getSingleProduct(Long product);



    String getAllProducts();
}
