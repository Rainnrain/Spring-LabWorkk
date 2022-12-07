package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;


import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts();
    ProductDTO createProduct(ProductDTO productDTO);
    void updateProduct(ProductDTO productDTO);
    List<ProductDTO> getProductByCategoryAndPrice(List<Long> categoryList, BigDecimal price);
    ProductDTO getProductByName(String name);
    List<ProductDTO> getTop3();
   List <ProductDTO> getProductByPriceandQuantity(BigDecimal price, Integer quantity);
    List<ProductDTO> getProductById(Long id);
    List<ProductDTO> findByPrice(BigDecimal price);

}
