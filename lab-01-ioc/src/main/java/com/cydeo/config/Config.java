package com.cydeo.config;

import com.cydeo.Currency;
import com.cydeo.account.Current;
import com.cydeo.account.Saving;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.UUID;

@Configuration
public class Config {

   @Bean
    public Current current(Currency currency){
       Current c= new Current();
       c.setAccountId(UUID.randomUUID());
       c.setCurrency(currency);
       c.setAmount(new BigDecimal("23"));
       return c;
   }
   @Bean
   public Saving saving(Currency currency){
       Saving s = new Saving();
       s.setAccountId(UUID.randomUUID());
       s.setAmount(new BigDecimal("500"));
       s.setCurrency(currency());
        return s;
   }

    @Bean
   public Currency currency(){
       return new Currency("Dollar", "one");
   }
}
