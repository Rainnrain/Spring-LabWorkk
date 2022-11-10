package com.cydeo.repository;

import com.cydeo.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository <Orders, Long> {
    //Write a derived query to get top 5 orders by order by total price desc
    //Write a derived query to get all orders by customer email
    //Write a derived query to get all orders by specific payment method
    //Write a derived query to get all orders by specific payment method
    //Write a derived query to get all orders by specific customer email
    //Write a derived query to check is there any orders by customer email
    //Write a native query to get all orders by specific product name


    @Query(value = "SELECT * from orders " +
            " JOIN cart  ON orders_cart_id =cart_id " +
            " JOIN cart_item  ON cart_item_id= cart_cart_item_id "+
            " Join product ON product_id= cart_item_product_id " +
            "Where product_name ILIKE concat ('%',?1,'%')", nativeQuery = true)
    List<Orders> findByProduct(@Param("product") String product);

    //Write a native query to get all orders by specific categoryId
    //Write a derived query to get all orders by totalPrice and paidPrice are equals
    //Write a derived query to get all orders by totalPrice and paidPrice are not equals and discount is not null

}
