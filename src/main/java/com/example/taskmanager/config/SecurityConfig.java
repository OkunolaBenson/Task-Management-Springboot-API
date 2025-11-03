package com.example.taskmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for simplicity (you can re-enable it later if needed)
                .csrf(csrf -> csrf.disable())

                // Allow access to Swagger UI and API docs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        // Allow all other endpoints for now (you can restrict later)
                        .anyRequest().permitAll()
                )

                // Optional login types (for browser use)
                .httpBasic(httpBasic -> {}) // enable basic auth
                .formLogin(form -> form.disable()); // disable login form

        return http.build();
    }
}
