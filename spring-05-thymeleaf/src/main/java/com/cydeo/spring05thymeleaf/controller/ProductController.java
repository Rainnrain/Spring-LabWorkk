package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Controller

public class ProductController {

    private final ProductServiceImpl productService;
    private final ProductRepository productRepository;

    public ProductController(ProductServiceImpl productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/create-form")
    public String createForm(Model model){
        model.addAttribute("product", new Product());
        return "product/create-product";
    }


    @PostMapping("/create-product")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            return "product/create-product";
        }

        productService.productCreate(product);
    return "redirect:/list";
}

    @GetMapping("/create-product")
    public String createProduct2() {

        return "redirect:/list";
    }


    @GetMapping("/list")
    public String listProduct(Model model){
    model.addAttribute("productList", productService.listProduct() );
        return "product/list";
    }


}
