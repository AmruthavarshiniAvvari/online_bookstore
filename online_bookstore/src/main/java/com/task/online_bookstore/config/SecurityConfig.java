package com.task.online_bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers(
                                "/",
                                "/register",
                                "/login",
                                "/css/**"
                        ).permitAll()

                        .requestMatchers(
                                "/addBook",
                                "/save",
                                "/edit/**",
                                "/delete/**",
                                "/dashboard"
                        ).hasAuthority("ADMIN")

                        .requestMatchers(
                                "/books",
                                "/cart",
                                "/addToCart/**"
                        ).hasAnyAuthority("USER","ADMIN")

                        .anyRequest().authenticated()
                )

                .formLogin(form -> form

                        .loginPage("/login")

                        .loginProcessingUrl("/login")

                        .failureUrl("/login?error=true")

                        .defaultSuccessUrl("/books", true)

                        .permitAll()
                )

                .logout(logout -> logout

                        .logoutSuccessUrl("/login?logout")

                        .permitAll()
                );

        return http.build();
    }
}