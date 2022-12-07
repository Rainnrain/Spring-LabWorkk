package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final MapperUtil mapperUtil;
    private final OrderService orderService;

    public OrderController(MapperUtil mapperUtil, OrderService orderService) {
        this.mapperUtil = mapperUtil;
        this.orderService = orderService;
    }

    @GetMapping
    ResponseEntity <ResponseWrapper> getAllOrders(){
        return ResponseEntity.ok(new ResponseWrapper("List of orders", orderService.findAllOrders(), HttpStatus.OK));
    }

    @PutMapping
    ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO){
        orderService.updateOrder(orderDTO);
      return ResponseEntity.ok(new ResponseWrapper("Order Updated",  HttpStatus.OK));
    }
    @PostMapping
    ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO){
        return ResponseEntity.ok(new ResponseWrapper("Order Updated", orderService.createOrder(orderDTO),   HttpStatus.OK));
    }

    @GetMapping("/payment/{payment}")
    ResponseEntity<ResponseWrapper> findOrderByPaymentType(@PathVariable ("payment")PaymentMethod paymentMethod){
        return ResponseEntity.ok(new ResponseWrapper("Order Updated", orderService.findOrdersByPaymentMethod(paymentMethod),   HttpStatus.OK));
    }

    @GetMapping("/email/{email}")
    ResponseEntity<ResponseWrapper> findOrderByEmail(@PathVariable ("email") String email){
        return ResponseEntity.ok(new ResponseWrapper("Order Updated", orderService.findOrderByEmail(email),   HttpStatus.OK));
    }



}
