package com.cydeo.spring05thymeleaf.service.impl;


import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean productCreate(Product product){
      if(productRepository.findAll().stream().filter(product1 -> product1.getName().equals(product.getName()))
              .anyMatch(product1 -> product1.getPrice().equals(product.getPrice()))){

        updateProduct(product);

        } else{

        product.setId(UUID.randomUUID());
        product.setQuantity(0);
          productRepository.save(product);
      }
    return true;
    }


    @Override
    public List<Product> listProduct() {
     return productRepository.findAll();
    }

    @Override
    public Product findProductById(UUID uuid){
       return productRepository.findProductById(uuid);
    }

    @Override
    public Product updateProduct(Product product) {


        Product productToUpdate= productRepository.findAll().stream()
                .filter(product1 -> product1.getName().equals(product.getName()) && ( product1.getPrice().equals(product.getPrice())))
                .findAny().orElseThrow();

        productToUpdate.setRemainingQuantity(productToUpdate.getRemainingQuantity()+product.getRemainingQuantity());

        return product;
    }


}
