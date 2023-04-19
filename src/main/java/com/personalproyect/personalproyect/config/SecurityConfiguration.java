package com.personalproyect.personalproyect.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.personalproyect.personalproyect.services.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

        @Autowired
        private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

        private JpaUserDetailsService service;

        public SecurityConfiguration(JpaUserDetailsService service) {
                this.service = service;
        }

        @Bean
        SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                .cors()
                                .and()
                                .headers(header -> header.frameOptions().sameOrigin())
                                .csrf(csrf -> csrf.disable())
                                .formLogin(form -> form.loginPage("/api/login")
                                .disable())
                                .logout(logout -> logout
                                                .logoutUrl("/api/logout")
                                                .deleteCookies("JSESSIONID"))
                                .authorizeHttpRequests((auth) -> auth
                                                        .requestMatchers("/**").permitAll()
                                                        .anyRequest().authenticated()
                                                        )
                                .userDetailsService(service)
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                                .httpBasic(basic -> basic
                                                .authenticationEntryPoint(authenticationEntryPoint));

                return http.build();

        }

        @Bean
        PasswordEncoder passwordEncoder() {
                
                return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        }

   

}
