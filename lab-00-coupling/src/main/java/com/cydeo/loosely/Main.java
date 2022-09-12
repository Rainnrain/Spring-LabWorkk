package com.cydeo.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        UUID user = UUID.randomUUID();

        Balance customerBalance =new CustomerBalance(user, BigDecimal.ZERO);
        Balance giftCardBalance = new CustomerBalance(user, BigDecimal.ZERO);

        customerBalance.addBalance(new BigDecimal(150));
        giftCardBalance.addBalance(new BigDecimal(120));

        BalanceManager balanceService = new BalanceManager( customerBalance);
        BalanceManager balanceService2= new BalanceManager(giftCardBalance);

        System.out.println(balanceService.checkout(new BigDecimal(80)));
        System.out.println(balanceService2.checkout(new BigDecimal(80)));
    }

}

