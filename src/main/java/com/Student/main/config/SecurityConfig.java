package com.Student.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Student.main.security.JwtFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private JwtFilter jwtFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())   // disable CSRF for APIs
            .authorizeHttpRequests(auth -> auth
            	.requestMatchers("/api/auth/**").permitAll() // ✅ allow login/register
                .requestMatchers("/api/students/**").authenticated() // allow all APIs for now
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .formLogin(form -> form.disable())  // disable default login page
            .httpBasic(basic -> basic.disable()); // disable basic auth

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}