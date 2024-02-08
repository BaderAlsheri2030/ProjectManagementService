package com.example.todolist.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProjectDTO {
    @Future(message = "due date can only be in future")
    private LocalDate due_date;
    @FutureOrPresent(message = "start date can only be in future or present")
    private LocalDate start_date;
    @NotNull(message ="project name cannot be null")
    private String project_name;
    @NotNull(message = "project status cannot be null")
    private String project_status;
}
