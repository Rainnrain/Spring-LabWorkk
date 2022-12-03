package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressServiceImpl implements AddressService {


    private final AddressRepository addressRepository;
    private final CustomerServiceImpl customerServiceimpl;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, CustomerServiceImpl customerServiceimpl, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.customerServiceimpl = customerServiceimpl;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AddressDTO> listAllAddresses() {
       return addressRepository.findAll().stream().map(p->mapperUtil.convert(p,new AddressDTO() ))
               .collect(Collectors.toList());
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO) {

    CustomerDTO customerDTO=customerServiceimpl.findById(addressDTO.getCustomerId());
    Customer customer=mapperUtil.convert(customerDTO, new Customer());
    List<Address> oldAddresses=addressRepository.findAllByCustomer(customer);

    Address updatedOldAddress=oldAddresses.stream().filter(p->p.getId().equals(addressDTO.getId()))
                    .map(   p-> {
                        p.setName(addressDTO.getName());
                        p.setStreet(addressDTO.getStreet());
                        p.setZipCode(addressDTO.getZipCode());
                        return p;
                            }
                    ).findFirst().orElseThrow();

    addressRepository.save(updatedOldAddress);



    return addressDTO;
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address createdAddress=mapperUtil.convert(addressDTO, new Address());
        Customer customer=mapperUtil.convert(customerServiceimpl.findById(addressDTO.getCustomerId()),new Customer());
        createdAddress.setCustomer(customer);
        return addressDTO;
    }
}
