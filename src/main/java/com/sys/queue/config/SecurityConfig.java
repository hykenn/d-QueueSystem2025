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
//                 .requestMatchers("/admin").permitAll()
//                 .requestMatchers("/table").permitAll()
//                 .requestMatchers("/Auth/login").permitAll()
//                 .requestMatchers("/register").permitAll()
//                 .requestMatchers("/logout").permitAll()
//                 .anyRequest().authenticated()  // Require authentication for all other requests
//             )
//             .formLogin(form -> form
//                 .defaultSuccessUrl("/", true)
//             )
//             .logout(config -> config.logoutSuccessUrl("/"))
//             .build();
//     }
// }
