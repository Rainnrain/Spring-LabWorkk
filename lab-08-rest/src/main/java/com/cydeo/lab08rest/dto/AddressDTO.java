package com.cydeo.lab08rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"id"}, ignoreUnknown = true)
public class AddressDTO{
    private Long id;
    private String name;
    private String zipCode;
    private String street;
    private Long customerId;
}
