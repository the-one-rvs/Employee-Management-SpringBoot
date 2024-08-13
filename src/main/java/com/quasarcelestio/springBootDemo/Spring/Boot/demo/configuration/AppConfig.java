package com.quasarcelestio.springBootDemo.Spring.Boot.demo.configuration;

import com.quasarcelestio.springBootDemo.Spring.Boot.demo.DB;
import com.quasarcelestio.springBootDemo.Spring.Boot.demo.DevDB;
import com.quasarcelestio.springBootDemo.Spring.Boot.demo.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean(){

        return new DevDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProbDBBean(){

        return new ProdDB();
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
