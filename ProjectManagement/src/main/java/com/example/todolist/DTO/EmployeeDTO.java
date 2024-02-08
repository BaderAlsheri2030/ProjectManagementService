package com.example.todolist.DTO;

import com.example.todolist.Model.Task;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    @NotNull(message = "user name cannot be null")
    private String userName;
    @NotNull(message = "password cannot be null")
    @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$")
    private String password;
    @NotNull(message = "email cannot be null")
    @Email(message = "must be a valid email")
    private String email;
    private UUID team_id;
    private UUID user_id;
    @NotNull(message = "first name cannot be null")
    private String firstName;
    @NotNull(message = "last name cannot be null")
    private String lastName;
    private String role;
    private Set<Task> tasks;

}
