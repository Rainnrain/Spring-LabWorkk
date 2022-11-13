package com.cydeo.repository;


import com.cydeo.entity.CartItem;
import com.cydeo.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

//    //Write a derived query to get count cart items
//
//    int countByQuantity();
//
//    //Write a derived query to get cart items for specific cart state
//   List<CartItem> findByCartCartState(CartState cartState);
//
//    //Write a native query to get cart items for specific cart state and product
//
//    @Query(value = "SELECT * FROM cart_item ci " +
//            " inner JOIN cart c on ci.cart_id=c.id " +
//            "inner JOIN product p on ci.product_id=p.id " +
//            "WHERE c.cart_state= ?1 AND p.name ilike concat ('%', ?2, '%')", nativeQuery = true)
//        List<CartItem> cartItemsByState(@Param("CartState")String cartState, @Param("product") String product);
//
//    @Query(nativeQuery = true, value = "select * from cart_item ci join cart c on ci.cart_id = c.id" +
//            "join product p on ci.product_id = p.id where c.cart_state = ?1 and p.name = ?2")
//    List<CartItem> retrieveCartItemWithSpecificStateAndProductName(String state, String productName);
//
////    @Query(value = "SELECT * FROM cart_item ci " +
////            "inner JOIN cart c on ci.cart_id=c.id  " +
////            "inner JOIN product p on ci.product_id=p.id "+
////            "where c.cart_state= ?1 and p.name ilike concat ('%', ?2, '%') ", nativeQuery = true)
////    List<CartItem> cartItemsByState(String cartState,  String product);
//    @Query(value = "select * from cart_item ci, product p, cart c" +
//            " where ci.product_id=p.id and p.name ilike concat ('%', ?1, '%') and ci.cart_id=c.id and c.cart_state = ?2 ",nativeQuery = true)
//    List<CartItem> retrieveCartsByCartStateAndProduct(String name, String state);
//    //Write a native query to get cart items for specific cart state and without discount
//
//    @Query(value = "select * from cart_item ci " +
//            "where ci.cart.state =?1 and ci.cart.discount.dicount=?2", nativeQuery = true)
//    List<CartItem> retrieveCartsByCartStateNodiscount(String state, int discount);
//
//    //Write a native query to get cart items for specific cart state and with specific Discount type
//
//    @Query(value = "select * from cart_item ci " +
//            "where ci.cart.state =?1 and ci.cart.discount.dicountType=?2", nativeQuery = true)
//    List<CartItem> retrieveCartsByCartStateDiscountType(String state, String discountType);

}
