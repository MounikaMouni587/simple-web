package com.telusko.simpleWebApp;

import com.telusko.simpleWebApp.dto.ProductDto;
import com.telusko.simpleWebApp.entity.Product;
import com.telusko.simpleWebApp.repository.ProductRepository;
import com.telusko.simpleWebApp.service.ProductService;
import com.telusko.simpleWebApp.serviceImpl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productServiceimpl;

    @Test
    void addProductShouldAddProductsSuccessfully()
    {
        System.out.println("my first unit test");
        ProductDto product=new ProductDto();
        product.setProdId(1);
        product.setProdName("mobile");
        product.setDescription("apple manufactring in china");
        product.setQuantity(2);
        product.setAvailability(true);
        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(productServiceimpl.productDtoToEntity(product));
        ProductDto addedProduct=productServiceimpl.addProducts(product);

        Assertions.assertEquals(product.getProdId(),addedProduct.getProdId());
    }
}
