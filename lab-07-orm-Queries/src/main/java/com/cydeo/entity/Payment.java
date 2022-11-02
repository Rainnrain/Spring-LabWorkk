package com.cydeo.entity;

import com.cydeo.enums.PaymentMethod;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Data
@NoArgsConstructor
public class Payment extends BaseEntity{

    private Double paidPrice;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
