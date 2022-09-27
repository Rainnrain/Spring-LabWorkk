package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Cart;
import com.cydeo.lab04springmvc.model.CartItem;
import com.cydeo.lab04springmvc.service.CartService;
import com.cydeo.lab04springmvc.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class cartController {

    private final CartService cartService;

    public cartController(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping("/cart-list/{id}")
    public String cartListId( @PathVariable UUID id, Model model){

        model.addAttribute("cartItemList",cartService.retrieveCartDetail(id));
        return "cart/cart-detail";
    }
    @RequestMapping("/cart-list")
    public String cartListId(Model model){

        model.addAttribute("cartList",cartService.retrieveCartList());
        return "cart/cart-list";
    }


}
