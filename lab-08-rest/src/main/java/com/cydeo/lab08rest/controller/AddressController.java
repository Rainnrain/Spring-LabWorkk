package com.cydeo.lab08rest.controller;


import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return ResponseEntity.ok( new ResponseWrapper("Address Updated", addressService.updateAddress(addressDTO), HttpStatus.OK));
    }
    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.ok(new ResponseWrapper("Address Created", addressService.createAddress(addressDTO), HttpStatus.OK));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressStartingWith(@PathVariable String address){
        return ResponseEntity.ok(new ResponseWrapper("Address found by start of address", addressService.addressStartsWith(address), HttpStatus.OK));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable Integer id){
        return ResponseEntity.ok(new ResponseWrapper("Address found by id", addressService.addressByCustomerId(id), HttpStatus.OK));
    }

    @GetMapping("/customer/{id}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerIdAndName(@PathVariable("id") Integer id, @PathVariable("name") String name){
        return ResponseEntity.ok(new ResponseWrapper("Address found by id and name", addressService.addressByCustomerIdAndName(id, name), HttpStatus.OK));
    }


}
