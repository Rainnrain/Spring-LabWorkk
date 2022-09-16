package com.cydeo.lab02yummy.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Ingredients {
    private String name;
    private int quantiy;
    QuantityType quantityType;
}
