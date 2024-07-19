package com.medicine.userService.config;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.medicine.userService.filter.JwtAuthenticationFilter;
import com.medicine.userService.service.UserService;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    @Order(1)
    public SecurityFilterChain publicSecurityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher("/register/**", "/login/**","/oauth2/**","/error/**")
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/register/**", "/login/**","/oauth2/**","/error/**").permitAll())
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/login")
                        .defaultSuccessUrl("/loginSuccess")
                        .failureUrl("/loginFailure"));
        System.out.println("Hye this is permitted");
        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain authenticatedSecurityFilterChain(HttpSecurity http, UserDetailsService userService,
            JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        System.out.println(http);
        http.securityMatcher("/**")
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .userDetailsService(userService)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @WebFilter("/*")
    public class RequestLoggingFilter extends HttpFilter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            // You can put filter initialization code here if needed
        }

        @Override
        protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
                throws IOException, ServletException, java.io.IOException {
            // Log request details
            System.out.println("Incoming Request:");
            System.out.println("URL: " + request.getRequestURL());
            System.out.println("Method: " + request.getMethod());
            System.out.println("Headers:");
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                System.out.println(headerName + ": " + request.getHeader(headerName));
            }

            // Continue with the filter chain
            chain.doFilter(request, response);

            // Log response details
            System.out.println("Outgoing Response:");
            System.out.println("Status: " + response.getStatus());
        }
    }




}
