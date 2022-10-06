package com.cydeo.spring05thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UUID id;
    private Integer remainingQuantity;
    private Integer quantity;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
    private String name;



}
