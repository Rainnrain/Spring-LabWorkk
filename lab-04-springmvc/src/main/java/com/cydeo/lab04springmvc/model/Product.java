package com.cydeo.lab04springmvc.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Product {
    private UUID id;
    private Integer remainingQuantity;
    private Integer quantity;
    private BigDecimal price;
    private String name;
}
