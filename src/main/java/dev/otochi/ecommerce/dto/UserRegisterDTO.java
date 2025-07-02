package dev.otochi.ecommerce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterDTO {
    @NotBlank
    @Size(min = 3, max = 24, message = "Password must be between 6 and 24 characters long")
    private String username;
    @NotBlank
    @Email(message = "Email invalid")
    private String email;
    @NotBlank
    @Size(min = 6, max = 24, message = "Password must be between 6 and 24 characters long")
    private String password;
    private String role = "USER";
}
