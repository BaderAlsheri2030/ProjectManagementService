package com.example.todolist.Service;

import com.example.todolist.API.ApiException;
import com.example.todolist.DTO.ProjectDTO;
import com.example.todolist.DTO.ProjectManagerDTO;
import com.example.todolist.Model.Project;
import com.example.todolist.Model.ProjectManager;
import com.example.todolist.Repository.ProjectManagerRepository;
import com.example.todolist.Repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProjectService {
   ProjectRepository projectRepository;
   ProjectManagerRepository projectManagerRepository;
    public void createProject(ProjectDTO projectDTO, UUID projectManager_id){
        ProjectManager manager = projectManagerRepository.findProjectManagerById(projectManager_id);
        if (manager == null){
            throw new ApiException("Not found");
        }
        Project project = new Project(null,projectDTO.getProject_name(),projectDTO.getStart_date(),projectDTO.getDue_date(), projectDTO.getProject_status(),null,manager);
        manager.getProjects().add(project);
        projectRepository.save(project);
        projectManagerRepository.save(manager);
    }

    public void deleteProject(UUID projectManager_id,UUID project_id){

    }

    public void updateProject(){

    }

    public Project displayProject(UUID project_id,UUID manager_id){
        Project project = projectRepository.findProjectById(project_id);
        return project;
    }


}
