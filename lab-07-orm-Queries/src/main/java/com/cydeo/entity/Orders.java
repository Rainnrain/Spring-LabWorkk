package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Orders extends BaseEntity {
    private Double paidPrice;
    private Double totalPrice;
    @OneToOne
    private Cart cart;
    @OneToOne
    private Payment payment;
    @ManyToOne
    private Customer customer;


    @Override
    public String toString() {
        return "Order{" +
                "paidPrice=" + paidPrice +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                ", cart=" + cart +
                ", payment=" + payment +
                '}';
    }
}
