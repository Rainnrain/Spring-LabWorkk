package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.CustomerRepository;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public CustomerServiceImpl(CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public CustomerDTO findById(long id) {
        Customer customer = customerRepository.findById(id).get();
        return mapperUtil.convert(customer, new CustomerDTO());
    }

    @Override
    public void update(CustomerDTO customerDTO) {

        Customer customer = mapperUtil.convert(customerDTO, new Customer());
        customerRepository.save(customer);
    }

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        customerDTO.setId(null);
        Customer customer = mapperUtil.convert(customerDTO, new Customer());
        customerRepository.save(customer);
        return customerDTO;
    }

    @Override
    public CustomerDTO findByEmail(String email) {
        Customer customer = customerRepository.retrieveByCustomerEmail(email);
        customerRepository.save(customer);
        return mapperUtil.convert(customer, new CustomerDTO());
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
       List<Customer> listOfCustomers=customerRepository.findAll();
      return listOfCustomers.stream().map(p-> mapperUtil.convert(p, new CustomerDTO()))
               .collect(Collectors.toList());
    }
}
