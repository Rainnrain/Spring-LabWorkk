package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Data
public class Orders extends BaseEntity{
    private Double paidPrice;
    private Double totalPrice;
    @OneToOne
    private Cart cart;
    @OneToOne
    private Payment payment;
    @ManyToOne
    private Customer customer;
}
