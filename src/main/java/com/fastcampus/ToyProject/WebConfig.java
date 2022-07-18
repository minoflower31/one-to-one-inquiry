package com.fastcampus.ToyProject;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class WebConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/", "/auth/**", "/js/**", "/image/**", "/webjars/**").permitAll();

        http.authorizeRequests().anyRequest().authenticated();

        http.csrf().disable();

        http.formLogin().loginPage("/auth/login");
        http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/");

        return http.build();
    }
}
