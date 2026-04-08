package dev.otochi.ecommerce.controller;

import dev.otochi.ecommerce.dto.UserDTO;
import dev.otochi.ecommerce.dto.UserRegisterDTO;
import dev.otochi.ecommerce.entity.UserEntity;
import dev.otochi.ecommerce.security.JwtUtil;
import dev.otochi.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserRegisterDTO userDto) {
        UserEntity user = new UserEntity();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole("USER");
        return ResponseEntity.ok(userService.create(user));
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        return userService.getByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            String token = jwtUtil.generateToken(request.getEmail());
            return ResponseEntity.ok(new TokenResponse(token));
        } catch (Exception ex) {
            return ResponseEntity.status(401).body("Invalid Credentials: " + ex.getMessage());
        }
    }


    @Getter
    @Setter
    public static class AuthRequest {
        private String email;
        private String password;
    }

    @Getter
    @AllArgsConstructor
    public static class TokenResponse {
        private String token;
    }
}
