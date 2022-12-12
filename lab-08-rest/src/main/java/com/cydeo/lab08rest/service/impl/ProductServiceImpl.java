package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.entity.Category;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
      return  productRepository.findAll().stream().map(p->
                mapperUtil.convert(p, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        productDTO.setId(null);
       productRepository.save(mapperUtil.convert(productDTO, new Product()));
       return productDTO;
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        productRepository.save(mapperUtil.convert(productDTO, new Product()));
        return productDTO;
    }

    @Override
    public List<ProductDTO>  getProductListByCategoryAndPrice(ProductRequest productRequest) {

    return productRepository.retrieveProductListByCategory(productRequest.getCategoryList(), productRequest.getPrice()).stream()
            .map(p->   mapperUtil.convert(p, new ProductDTO()))
                .collect(Collectors.toList());


    }

    @Override
    public ProductDTO getProductByName(String name) {
     return  mapperUtil.convert( productRepository.findFirstByName(name), new ProductDTO());
    }

    @Override
    public List<ProductDTO> getTop3() {
        return productRepository.findTop3ByOrderByPriceDesc().stream()
                .map(p->
                        mapperUtil.convert(p, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductByPriceandQuantity(BigDecimal price, Integer quantity) {

     return  productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(price, quantity).stream()
                .map(p->
                        mapperUtil.convert(p, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductById(Long id) {
        return   productRepository.retrieveProductListByCategory(id).stream()
                .map(p->
                        mapperUtil.convert(p, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer findByPrice(BigDecimal price) {
       return productRepository.countProductByPriceGreaterThan(price);

    }
}
