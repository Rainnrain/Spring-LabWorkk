package com.cydeo.lab04springmvc;

import com.cydeo.lab04springmvc.service.CartService;
import com.cydeo.lab04springmvc.service.ProductService;
import com.cydeo.lab04springmvc.service.impl.CartServiceImpl;
import com.cydeo.lab04springmvc.service.impl.ProductServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.UUID;

@SpringBootApplication
public class Lab04SpringmvcApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Lab04SpringmvcApplication.class, args);
        ProductServiceImpl productService = context.getBean(ProductServiceImpl.class);
        productService.initialiseProductList();

        CartServiceImpl cartService = context.getBean(CartServiceImpl.class);
        cartService.initialiseCartList();


    }

}
