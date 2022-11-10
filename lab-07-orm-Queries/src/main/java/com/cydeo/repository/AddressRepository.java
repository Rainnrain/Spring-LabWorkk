package com.cydeo.repository;

import com.cydeo.entity.Address;
import com.cydeo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressRepository extends JpaRepository<Address, String> {

    //Write a derived query to get all address with a specific customer

    List<Address> findByCustomer(Customer customer);//?

    //Write a derived query to get address with a specific street

    List<Address> findByStreet(String street);
    //Write a derived query to get top 3 address with a specific customer email
    List<Address> findAddressByCustomer_Email(String email); // Returns Blank
    List<Address> findTopByCustomerEmail(String email); // Not working

    //Write a derived query to get all address with a specific customer and name
    List<Address> findByCustomer_FirstName(String firstName);
    //Write a derived query to list all address where the beginning
    // of the street contains the keyword

    List<Address> findByStreetContainsIgnoreCase(String word);
    //Write a JPQL query to get all address with a specific customerId

    @Query("SELECT e From Address e where e.customer.id=?1")
    List<Address> addressesWithASpecificCustomerIDJPQL(Long id);


}
