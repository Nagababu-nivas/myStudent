package com.example.Student.Security;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SecurityConfig {

    // --- Spring Security (adjust matchers as needed) ---
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());
        // Optionally authorize requests here:
        // .authorizeHttpRequests(auth -> auth
        //     .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
        //     .anyRequest().permitAll()
        // );
        return http.build();
    }

    // --- Global CORS configuration for your API ---
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration c = new CorsConfiguration();
        // For demos use "*"; for tighter security, put the exact Killercoda origin.
        c.setAllowedOrigins(List.of("*"));
        c.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
        c.setAllowedHeaders(List.of("*"));
        c.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", c);
        return source;
    }

    // --- OpenAPI: relative server URL so Swagger UI sticks to same origin/scheme ---
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().servers(List.of(new Server().url("/")));
    }
}