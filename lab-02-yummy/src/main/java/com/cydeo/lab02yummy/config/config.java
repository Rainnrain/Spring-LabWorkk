package com.cydeo.lab02yummy.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class config {
    @Bean
   public Faker faker(){
        return new Faker();
    }


}
