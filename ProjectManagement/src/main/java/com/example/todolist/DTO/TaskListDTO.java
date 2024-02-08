package com.example.todolist.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class TaskListDTO {
    private UUID team_id;
    private String title;
}
