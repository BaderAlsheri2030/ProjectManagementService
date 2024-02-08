package com.example.todolist.DTO;

import com.example.todolist.Model.Employee;
import com.example.todolist.Model.TaskList;
import com.example.todolist.Model.TeamLeader;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
public class TeamDTO {
    private UUID project_id;
    private String team_name;
}