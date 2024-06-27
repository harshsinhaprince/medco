package com.medicine.apiggteway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
            .csrf().disable()
            .authorizeExchange(exchanges -> exchanges
                .pathMatchers("/api/users/**").permitAll()
                .pathMatchers("/api/medicines/**", "/api/orders/**", "/api/payments/**", "/api/notifications/**").authenticated()
                .anyExchange().authenticated());
          //  .oauth2Login(); // Example for OAuth2 login
        return http.build();
    }
}