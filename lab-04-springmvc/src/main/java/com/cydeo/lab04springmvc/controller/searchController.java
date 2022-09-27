package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Product;
import com.cydeo.lab04springmvc.service.ProductService;
import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class searchController {

    private final ProductService productService;

    public searchController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/search-product/{product}")
    public String search(@PathVariable String product, Model model){

        model.addAttribute("productList", productService.searchProduct(product));

        return "product/product-list";
    }
}
