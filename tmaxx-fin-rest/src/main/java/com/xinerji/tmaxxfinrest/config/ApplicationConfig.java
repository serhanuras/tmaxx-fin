package com.xinerji.tmaxxfinrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Autowired
    private DatabaseConfig databaseConfig;

    public DatabaseConfig getDatabaseConfig() {
        return databaseConfig;
    }

}
