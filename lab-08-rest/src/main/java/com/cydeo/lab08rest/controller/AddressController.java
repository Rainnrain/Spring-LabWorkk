package com.cydeo.lab08rest.controller;


import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity <ResponseWrapper> getAddress(){

       return  ResponseEntity.ok(new ResponseWrapper("List of addresses Retreived", addressService.listAllAddresses(), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity <ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok( new ResponseWrapper("Address Created", addressService.updateAddress(addressDTO), HttpStatus.OK));
    }
}
