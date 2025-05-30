package com.telusko.simpleWebApp.service;

import com.telusko.simpleWebApp.dto.ProductDto;
import com.telusko.simpleWebApp.dto.UsersDto;
import com.telusko.simpleWebApp.entity.Product;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    public ProductDto addProducts(ProductDto productDto);

    List<Product> getProducts();

    ProductDto getProdcutById(long prodId);

    List<ProductDto> getProductPrice(long price);


}
