package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> listAllAddresses();

    AddressDTO updateAddress(AddressDTO addressDTO);

    AddressDTO createAddress(AddressDTO addressDTO);
    List <AddressDTO> addressStartsWith(String startsWith);

    List<AddressDTO> addressByCustomerId(Integer id);

    List<AddressDTO> addressByCustomerIdAndName(Integer id, String name);
}
