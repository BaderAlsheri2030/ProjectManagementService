package com.example.todolist.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProjectManagerDTO {
    private UUID user_id;
    @NotNull(message = "first name cannot be null")
    private String firstName;
    @NotNull(message = "last name cannot be null")
    private String lastName;
    private String role;
    @NotNull(message = "user name cannot be null")
    private String userName;
    @NotNull(message = "password cannot be null")
    @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$")
    private String password;
    @NotNull(message = "email cannot be null")
    @Email(message = "must be a valid email")
    private String email;
}