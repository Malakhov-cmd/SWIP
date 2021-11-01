package com.example.swip.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and().oauth2Login();*/

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home/**", "/login**", "/static/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login().permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/")
                .permitAll();
    }
}

