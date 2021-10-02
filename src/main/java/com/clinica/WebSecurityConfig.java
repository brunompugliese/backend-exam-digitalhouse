package com.clinica;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html").hasAnyRole("USER", "ADMIN")
                .antMatchers("/turnos.html").hasAnyRole("USER", "ADMIN")
                .antMatchers("/alta-turnos.html").hasAnyRole("USER", "ADMIN")
                .antMatchers("/odontologos.html").hasRole("ADMIN")
                .antMatchers("/alta-odontologos.html").hasRole("ADMIN")
                .antMatchers("/pacientes.html").hasRole("ADMIN")
                .antMatchers("/alta-pacientes.html").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .logout();
    }
}