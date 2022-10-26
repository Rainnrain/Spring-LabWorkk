package com.cydeo.lab06orm.entity;

import com.cydeo.lab06orm.enums.DiscountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Entity
@NoArgsConstructor
public class Discount extends BaseEntity{

    private Integer discount;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    private String name;
}
