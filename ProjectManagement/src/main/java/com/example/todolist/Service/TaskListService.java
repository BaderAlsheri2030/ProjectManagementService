package com.example.todolist.Service;

import com.example.todolist.API.ApiException;
import com.example.todolist.DTO.TaskListDTO;
import com.example.todolist.Model.TaskList;
import com.example.todolist.Model.Team;
import com.example.todolist.Repository.TaskListRepository;
import com.example.todolist.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskListService {
    TaskListRepository taskListRepository;
    TeamRepository teamRepository;
    public void createTaskList(TaskListDTO taskListDTO, UUID team_id){
        Team team = teamRepository.findTeamById(team_id);
        if (team == null){
            throw new ApiException("Invalid input");
        }
        TaskList taskList = new TaskList(null,taskListDTO.getTitle(),team,null);
        team.getTaskLists().add(taskList);
        taskListRepository.save(taskList);
        teamRepository.save(team);
    }
}
