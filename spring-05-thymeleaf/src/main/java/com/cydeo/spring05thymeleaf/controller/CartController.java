package com.cydeo.spring05thymeleaf.controller;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class CartController {

    private final CartServiceImpl cartServiceImpl;

    public CartController(CartServiceImpl cartServiceImpl) {
        this.cartServiceImpl = cartServiceImpl;
    }

    @GetMapping("/cart")
    public String viewCart(Model model){
    model.addAttribute("cartItemList", CartServiceImpl.CART.getCartItemList());
    model.addAttribute("cart", CartServiceImpl.CART.getCartTotalAmount());
        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{id}/{quantity}")
    public String addToCart(@PathVariable UUID id, @PathVariable Integer quantity){

        cartServiceImpl.addToCart(id,quantity);

        return "redirect:/cart";
    }

    @GetMapping("/delete/{productId}")
    public String delete(@PathVariable UUID productId){

        cartServiceImpl.deleteFromCart(productId);

       return "redirect:/cart";
    }

}
