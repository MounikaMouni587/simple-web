package com.telusko.simpleWebApp.controller;

import com.telusko.simpleWebApp.dto.ProductDto;
import com.telusko.simpleWebApp.dto.UsersDto;
import com.telusko.simpleWebApp.entity.Product;
import com.telusko.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("/post/product")
    public ResponseEntity<ProductDto> addProducts(@RequestBody ProductDto productDto)
    {
        return new ResponseEntity<>(productService.addProducts(productDto), HttpStatus.OK);
    }

    @GetMapping("/get/product")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getProducts(),HttpStatus.OK);
    }
    @GetMapping("/get/{prod_Id}/product")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long prod_Id)
    {
        return new ResponseEntity<>(productService.getProdcutById(prod_Id),HttpStatus.OK);
    }

    @GetMapping("/get/{price}")
    public ResponseEntity<List<ProductDto>> getProductsPrice(@PathVariable long price)
    {
        return new ResponseEntity<>(productService.getProductPrice(price),HttpStatus.OK);
    }

}
