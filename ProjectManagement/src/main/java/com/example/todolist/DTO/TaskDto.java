package com.example.todolist.DTO;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TaskDto {
    @NotNull(message = "Due date cannot be null")
    @Future
    private LocalDate dueDate;
    @NotNull(message = "Start date cannot be null")
    @FutureOrPresent
    private LocalDate startDate;
    @NotNull(message = "Description cannot be null")
    private String description;
    @NotNull(message = "Priority cannot be null")
    @Pattern(regexp = "Low|Medium|High",message = "Priority must be either Low, Medium, High")
    private String priority;
    @NotNull(message = "Task name cannot be null")
    private String taskName;
    private String status;

}