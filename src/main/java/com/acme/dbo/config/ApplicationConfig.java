package com.acme.dbo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PUBLIC;

@Configuration
@EnableWebSecurity
@ComponentScan("com.acme")
@AllArgsConstructor(access = PUBLIC)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ApplicationConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureJackson(ObjectMapper jackson2ObjectMapper) {
        //nothing to do with mapper
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security.cors().disable().csrf().disable();
        security.httpBasic().disable();
    }

}
