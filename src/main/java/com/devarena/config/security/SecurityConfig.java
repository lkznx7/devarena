package com.devarena.config.security;

import com.devarena.security.filters.JwtAuthenticationFilter;
import com.devarena.security.handlers.CustomOAuth2SuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final CustomOAuth2SuccessHandler customOAuth2SuccessHandler;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter,
                          AuthenticationConfiguration authenticationConfiguration,
                          CustomOAuth2SuccessHandler customOAuth2SuccessHandler) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationConfiguration = authenticationConfiguration;
        this.customOAuth2SuccessHandler = customOAuth2SuccessHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((r) -> r.requestMatchers("/auth/login", "/auth/register",
                        "/auth/forgot-password", "/auth/reset-password",
                        "/auth/verify-email", "/auth/onboarding",
                        "/auth/refresh", "/auth/logout",
                        "/email/test", "/oauth2/**", "/login/**").permitAll().anyRequest().authenticated())
                .oauth2Login(oauth2 -> oauth2
                        .successHandler(customOAuth2SuccessHandler)
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager () throws Exception{
        AuthenticationManager auth = authenticationConfiguration.getAuthenticationManager();
        return auth;
    }
}