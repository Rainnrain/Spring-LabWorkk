package com.cydeo.lab06orm.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NoArgsConstructor
@Data
public class Balance extends BaseEntity{
    private Double amount;
    @OneToOne
    private Customer customer;

}
