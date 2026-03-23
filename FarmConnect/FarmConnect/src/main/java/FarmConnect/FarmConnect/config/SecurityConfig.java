package FarmConnect.FarmConnect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
        .csrf(csrf->csrf.disable())
        .authorizeHttpRequests(auth->auth
                .requestMatchers("/api/users/**","/swagger-ui/**","/v3/api-docs/**").permitAll()
                .requestMatchers("/api/farmers/**","/swagger-ui/**","/v3/api-docs/**").permitAll()
             
                .requestMatchers("/api/farmers/**","/swagger-ui/**").hasRole("FARMER")
                .anyRequest().authenticated()
        );

        return http.build();
    }

}
