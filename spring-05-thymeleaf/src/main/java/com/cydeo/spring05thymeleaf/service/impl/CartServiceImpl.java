package com.cydeo.spring05thymeleaf.service.impl;

import com.cydeo.spring05thymeleaf.model.Cart;
import com.cydeo.spring05thymeleaf.model.CartItem;
import com.cydeo.spring05thymeleaf.model.Product;
import com.cydeo.spring05thymeleaf.service.CartService;
import com.cydeo.spring05thymeleaf.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CartServiceImpl implements CartService {


    public static Cart CART = new Cart(BigDecimal.ZERO, new ArrayList<>());
    public static List<CartItem> cartItemList= new ArrayList<>();

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method
        //todo initialise cart item
        //todo calculate cart total amount
        //todo add to cart

        if(cartItemList.stream().map(p->p.getProduct()).anyMatch(product ->product.getId().toString().equals(productId.toString()) )) {

            CartItem cartItem =cartItemList.stream().filter(p->p.getProduct().getId().toString().equals(productId.toString())).findAny().orElseThrow();

            Product product= cartItem.getProduct();

            product.setQuantity(product.getQuantity()+product.getRemainingQuantity());

            cartItem.setQuantity(product.getQuantity());
            cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));

            CART.setCartItemList(cartItemList);
            CART.setCartTotalAmount(CART.getCartTotalAmount().add((product.getPrice().multiply(BigDecimal.valueOf(product.getRemainingQuantity())))));


        } else{

           Product product= productService.findProductById(productId);
           product.setQuantity(product.getRemainingQuantity());
            CartItem cartItem= new CartItem(product, product.getRemainingQuantity(), product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())));
            cartItemList.add(cartItem);
            CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
           CART.setCartItemList(cartItemList);
        }
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){

       BigDecimal amountToDelete=cartItemList.stream()
               .filter(p->p.getProduct().getId().toString().equals(productId.toString()))
               .map(p->p.getTotalAmount())
               .findAny().orElseThrow();


     cartItemList.removeIf(p->p.getProduct().getId().toString().equals(productId.toString()));
    // CART.setCartItemList(cartItemList);

     CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(amountToDelete));

        return true;
    }
}
