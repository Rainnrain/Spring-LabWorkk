package com.cydeo.loosely;

import com.cydeo.CustomerBalance;
import com.cydeo.GiftCardBalance;
import java.math.BigDecimal;

public class BalanceManager {

    Balance balance;

    public BalanceManager(Balance balance) {
        this.balance = balance;
    }

    public boolean checkout(BigDecimal checkoutAmount) {

        BigDecimal balanceAmount=  balance.getAmount();

        return balanceAmount.subtract(checkoutAmount)
                .compareTo(BigDecimal.ZERO) > 0;

    }
}
