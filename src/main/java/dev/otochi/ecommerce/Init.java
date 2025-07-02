package dev.otochi.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
@EnableWebSecurity
public class Init {

    public static void main(String[] args) {
        SpringApplication.run(Init.class, args);
    }

//    // 🔓 Config moderna sin deprecaciones (Spring Security 6.1+)
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
//                .httpBasic(Customizer.withDefaults()); // opcional si querés autenticación básica habilitada
//        return http.build();
//    }
}
