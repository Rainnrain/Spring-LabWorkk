package com.cydeo.lab04springmvc.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CartItem {
    private Integer quantity;
    private Product product;
}
