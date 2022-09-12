package com.cydeo.loosely;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter

public abstract class Balance {
    private UUID userId;
    private BigDecimal amount;


   public abstract BigDecimal addBalance(BigDecimal amount);

    public Balance(UUID userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }
}
