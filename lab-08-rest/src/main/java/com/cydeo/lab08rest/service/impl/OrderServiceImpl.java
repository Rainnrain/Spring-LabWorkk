package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;

    private final MapperUtil mapperUtil;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<OrderDTO> findAllOrders() {
       return orderRepository.findAll().stream()
               .map(p->mapperUtil.convert(p, new OrderDTO())).collect(Collectors.toList());
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {

    orderRepository.save(mapperUtil.convert(orderDTO,new Order()));
    return orderDTO;
    }

    @Override
    public void updateOrder(OrderDTO orderDTO) {
    orderDTO.setId(null);
        orderRepository.save(mapperUtil.convert(orderDTO,new Order()));

    }

    @Override
    public List<OrderDTO> findOrdersByPaymentMethod(PaymentMethod paymentMethod) {
    return orderRepository.findAllByPayment_PaymentMethod(paymentMethod).stream()
            .map(p->mapperUtil.convert(p, new OrderDTO())).collect(Collectors.toList());

    }

    @Override
    public List<OrderDTO> findOrderByEmail(String email) {
        return orderRepository.findAllByCustomer_Email(email).stream()
                .map(p->mapperUtil.convert(p, new OrderDTO())).collect(Collectors.toList());
    }
}
