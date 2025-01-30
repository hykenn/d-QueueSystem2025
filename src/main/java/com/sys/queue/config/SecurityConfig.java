// package com.sys.queue.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         return http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/").permitAll()
//                 .requestMatchers("/login").permitAll()
//                 .requestMatchers("/register").permitAll()
//                 .requestMatchers("/logout").permitAll()
//                 .requestMatchers("/api/v1/queue/add").permitAll()  // Make /add endpoint publicly accessible
//                 .requestMatchers("/api/v1/queue/update/{id}").permitAll()  // Allow /update/{id} without authentication
//                 .requestMatchers("/api/v1/queue/que-office/{officeto}").permitAll()  // Allow /que-office/{officeto} without authentication
//                 .requestMatchers("/api/v1/queue/delete/{id}").permitAll()  // Allow /delete/{id} without authentication
//                 .requestMatchers("/api/v1/queue/all-quenum").permitAll()  // Allow /all-quenum without authentication
//                 .requestMatchers("/api/v1/queue/all-officeto").permitAll()  // Allow /all-officeto without authentication
//                 .requestMatchers("/api/v1/queue/all").permitAll()  // Allow /all without authentication
//                 .requestMatchers("/api/v1/queue/get-listby-office/{officeto}").permitAll()  // Allow /get-listby-office/{officeto} without authentication
//                 .anyRequest().authenticated()  // Require authentication for all other requests
//             )
//             .formLogin(form -> form
//                 .defaultSuccessUrl("/", true)
//             )
//             .logout(config -> config.logoutSuccessUrl("/"))
//             .build();
//     }
// }
