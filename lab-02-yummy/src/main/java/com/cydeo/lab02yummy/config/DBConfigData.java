package com.cydeo.lab02yummy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

    @ConfigurationProperties(prefix="db")
    @Data
    @Configuration
    public class DBConfigData {

        private String name;
        private String surname;
        private String email;
        private String social;

    }

