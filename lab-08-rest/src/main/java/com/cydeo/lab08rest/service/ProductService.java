package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.entity.Category;


import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts();
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO);
    List<ProductDTO>  getProductListByCategoryAndPrice(ProductRequest productRequest);
    ProductDTO getProductByName(String name);
    List<ProductDTO> getTop3();
   List <ProductDTO> getProductByPriceandQuantity(BigDecimal price, Integer quantity);
    List<ProductDTO> getProductById(Long id);
    Integer findByPrice(BigDecimal price);

}
