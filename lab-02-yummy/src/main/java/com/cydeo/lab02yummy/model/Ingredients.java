package com.cydeo.lab02yummy.model;

import lombok.Data;

@Data
public class Ingredients {
    private String name;
    private int quantity;
    private QuantityType quantityType;
}
