package com.example.todolist.Service;

import com.example.todolist.DTO.ProjectManagerDTO;
import com.example.todolist.Model.ProjectManager;
import com.example.todolist.Model.User;
import com.example.todolist.Repository.ProjectManagerRepository;
import com.example.todolist.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectManagerService {
    ProjectManagerRepository projectManagerRepository;
    UserRepository userRepository;


    public void register(ProjectManagerDTO projectManagerDTO){
        User user = new User(null,projectManagerDTO.getUserName(),projectManagerDTO.getPassword(),projectManagerDTO.getEmail(),"Manager",null,null,null);
        ProjectManager manager = new ProjectManager(null, projectManagerDTO.getFirstName(), projectManagerDTO.getLastName(),user.getRole(),null,user);
        user.setProjectManager(manager);
        projectManagerRepository.save(manager);
        userRepository.save(user);
    }
}