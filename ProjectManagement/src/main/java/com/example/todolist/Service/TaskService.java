package com.example.todolist.Service;

import com.example.todolist.DTO.TaskDto;
import com.example.todolist.Model.Task;
import com.example.todolist.Repository.TaskListRepository;
import com.example.todolist.Repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;


    public Task displayTask(UUID task_id){
        return taskRepository.findTaskById(task_id);
    }

    public void createTask(TaskDto taskDto){
        Task task = new Task(null,taskDto.getTaskName(),taskDto.getDescription(),taskDto.getPriority(),taskDto.getStatus(),taskDto.getStartDate(),taskDto.getDueDate(),null,null);
        taskRepository.save(task);
    }

    //delete task if the role is team leader
    public void deleteTask(UUID task_id){
        Task task = taskRepository.findTaskById(task_id);
        taskRepository.delete(task);
    }

    //update task if the role is team leader
    public void updateTask(UUID task_id,TaskDto taskDto){
        Task task = taskRepository.findTaskById(task_id);
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setStartDate(taskDto.getStartDate());
        task.setTaskName(taskDto.getTaskName());
        task.setPriority(taskDto.getPriority());
        taskRepository.save(task);
    }
}
