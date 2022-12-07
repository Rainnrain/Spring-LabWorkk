package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCustomers(){
        return ResponseEntity.ok(new ResponseWrapper("List of Customers", customerService.findAllCustomers(), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomers(@RequestBody CustomerDTO customerDTO){
        customerService.update(customerDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper("List of Customers", HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomers(@RequestBody CustomerDTO customerDTO){
        return ResponseEntity.ok(new ResponseWrapper("List of Customers", customerService.create(customerDTO), HttpStatus.OK));
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> findEmailByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(new ResponseWrapper("List of Customers", customerService.findByEmail(email), HttpStatus.OK));
    }
}
