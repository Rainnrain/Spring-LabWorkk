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
        List<Address> listOfAddresses=addressRepository.retrieveByCustomerId(addressDTO.getCustomerId());
        Address updatedAddress= listOfAddresses.stream()
                .filter(p->p.getId().equals(addressDTO.getId()))
                .findAny()
               .map(p->{
                   p.setName(addressDTO.getName());
                   p.setZipCode(addressDTO.getZipCode());
                   p.setStreet(addressDTO.getStreet());
                   p.setCustomer(mapperUtil.convert(customerServiceimpl.findById(addressDTO.getCustomerId()),new Customer()));
            return addressRepository.save(p);
               }).orElseGet( ()->{
                            Address address = mapperUtil.convert(addressDTO, new Address());
                            Customer customer = mapperUtil.convert(customerServiceimpl.findById(addressDTO.getCustomerId()), new Customer());
                            address.setCustomer(customer);
                            return addressRepository.save(address);});
        return addressDTO;
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address createdAddress=mapperUtil.convert(addressDTO, new Address());
        Customer customer=mapperUtil.convert(customerServiceimpl.findById(addressDTO.getCustomerId()),new Customer());
        createdAddress.setCustomer(customer);
        addressRepository.save(createdAddress);
        return addressDTO;
    }

    @Override
    public List<AddressDTO> addressStartsWith(String address) {
    List <Address> addresses= addressRepository.findAllByStreetStartingWith(address);
    return addresses.stream().map(p-> mapperUtil.convert(p, new AddressDTO()))
             .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> addressByCustomerId(Integer id) {
        Customer customer=mapperUtil.convert(customerServiceimpl.findById(id), new Customer());
        List <Address> addresses= addressRepository.findAllByCustomer(customer);
        return addresses.stream().map(p-> mapperUtil.convert(p, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> addressByCustomerIdAndName(Integer id, String name) {
        Customer customer=mapperUtil.convert(customerServiceimpl.findById(id), new Customer());
        List <Address> addresses= addressRepository.findAllByCustomerAndName(customer, name);
        return addresses.stream().map(p-> mapperUtil.convert(p, new AddressDTO()))
                .collect(Collectors.toList());
    }


}
