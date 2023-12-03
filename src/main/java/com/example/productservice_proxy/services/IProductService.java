package com.example.productservice_proxy.services;

import com.example.productservice_proxy.dtos.ProductDto;
import com.example.productservice_proxy.models.Product;
import java.util.List;

public interface IProductService {
    Product addNewProduct(ProductDto product);

   // Product addNewProduct(Product product);

    String updateProduct(Long product);

    String deleteProduct(Long product);

  Product getSingleProduct(Long product);




    List<Product> getAllProducts();
}
