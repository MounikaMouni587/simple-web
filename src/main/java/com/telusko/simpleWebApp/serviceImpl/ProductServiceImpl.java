package com.telusko.simpleWebApp.serviceImpl;

import com.telusko.simpleWebApp.dto.ProductDto;
import com.telusko.simpleWebApp.dto.UsersDto;
import com.telusko.simpleWebApp.entity.Product;
import com.telusko.simpleWebApp.exception.ProductNotFound;
import com.telusko.simpleWebApp.repository.ProductRepository;
import com.telusko.simpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;
    @Override
    public ProductDto addProducts(ProductDto productDto) {
        Product p=productDtoToEntity(productDto);
        productRepository.save(p);
        return entityToProductDto(p);
    }

    public Product productDtoToEntity(ProductDto productDto)
    {
        Product product=new Product();
        product.setPrice(productDto.getPrice());
        product.setProdId(productDto.getProdId());
        product.setProdName(productDto.getProdName());
        product.setAvailability(productDto.isAvailability());
        product.setCategory(productDto.getCategory());
        product.setDescription(productDto.getDescription());
        product.setReleaseDate(productDto.getReleaseDate());
        product.setQuantity(productDto.getQuantity());
        return product;
    }

    public ProductDto entityToProductDto(Product product)
    {
        ProductDto productDto=new ProductDto();
        productDto.setPrice(product.getPrice());
        productDto.setProdId(product.getProdId());
        productDto.setProdName(product.getProdName());
        productDto.setAvailability(product.isAvailability());
        productDto.setCategory(product.getCategory());
        productDto.setDescription(product.getDescription());
        productDto.setReleaseDate(product.getReleaseDate());
        productDto.setQuantity(product.getQuantity());
        return productDto;
    }
    @Override
    public List<Product> getProducts() {
       return productRepository.findAll();
    }

    @Override
    public ProductDto getProdcutById(long prodId) {
        Product p= productRepository.findById(prodId).orElseThrow(()->new ProductNotFound("product is not found"));
        return entityToProductDto(p);
    }

    @Override
    public List<ProductDto> getProductPrice(long price) {
        List<Product> p= productRepository.findByPrice(price);
        return p.stream().map(p2->entityToProductDto(p2)).filter(p1->p1.getPrice()<400000 ).collect(Collectors.toList());

    }

}
