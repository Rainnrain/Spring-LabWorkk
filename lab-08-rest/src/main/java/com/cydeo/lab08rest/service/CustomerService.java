package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;


public interface CustomerService {
    CustomerDTO findById(long id);
    void update(CustomerDTO customerDTO);
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO findByEmail(String email);

    List<CustomerDTO> findAllCustomers();
}
