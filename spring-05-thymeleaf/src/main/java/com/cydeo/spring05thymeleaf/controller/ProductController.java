package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.repository.ProductRepository;
import com.cydeo.spring05thymeleaf.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String createProduct(@ModelAttribute("product") Product product, Model model) {
    productService.productCreate(product);
    productRepository.save(product);
    return "redirect:/list";
}


    @GetMapping("/list")
    public String listProduct(Model model){

    model.addAttribute("productList", productService.listProduct() );
        return "product/list";
    }


}
