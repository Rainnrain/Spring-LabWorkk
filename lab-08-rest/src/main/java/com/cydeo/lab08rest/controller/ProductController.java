package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    ResponseEntity<ResponseWrapper> getAllProducts(){
        return  ResponseEntity.ok(new ResponseWrapper("All products", productService.findAllProducts(), HttpStatus.OK));
    }

    @PutMapping
    ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO){
        productService.updateProduct(productDTO);
        return  ResponseEntity.ok(new ResponseWrapper("Product updated", HttpStatus.OK));
    }

    @PostMapping
    ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO){

        return  ResponseEntity.ok(new ResponseWrapper("Product updated", productService.createProduct(productDTO), HttpStatus.OK));
    }
    @PostMapping("/categoryandprice")
    ResponseEntity<ResponseWrapper> createProductRequest(List<Long> categoryList, BigDecimal price){

        return  ResponseEntity.ok(new ResponseWrapper("Product updated", productService.getProductByCategoryAndPrice(categoryList, price), HttpStatus.OK));
    }

    @GetMapping("/{name}")
    ResponseEntity<ResponseWrapper> getAllProductsByName(@PathVariable("name") String name){
        return  ResponseEntity.ok(new ResponseWrapper("All products", productService.getProductByName(name), HttpStatus.OK));
    }

    @GetMapping("/top3")
    ResponseEntity<ResponseWrapper> gettop2(){
        return  ResponseEntity.ok(new ResponseWrapper("All products", productService.getTop3(), HttpStatus.OK));
    }
    @GetMapping("/price/{price}")
    ResponseEntity<ResponseWrapper> getbyPrice(@PathVariable("price") BigDecimal price){
        return  ResponseEntity.ok(new ResponseWrapper("All products", productService.findByPrice(price), HttpStatus.OK));
    }
    @GetMapping("/price/{price}/quantity/{quantity}")
    ResponseEntity<ResponseWrapper> getbyPiceAndQuantity(@PathVariable("price") BigDecimal price, @PathVariable("quantity") Integer quantity){
        return  ResponseEntity.ok(new ResponseWrapper("All products", productService.getProductByPriceandQuantity(price, quantity), HttpStatus.OK));
    }
    @GetMapping("/category/{id}")
    ResponseEntity<ResponseWrapper> getbyCategoryId(@PathVariable("id") Long id){
        return  ResponseEntity.ok(new ResponseWrapper("All products", productService.getProductById(id), HttpStatus.OK));
    }
}
