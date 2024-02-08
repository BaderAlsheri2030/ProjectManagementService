package com.example.todolist.Service;

import com.example.todolist.API.ApiException;
import com.example.todolist.DTO.TeamDTO;
import com.example.todolist.Model.Project;
import com.example.todolist.Model.Team;
import com.example.todolist.Model.TeamLeader;
import com.example.todolist.Repository.ProjectRepository;
import com.example.todolist.Repository.TeamLeaderRepository;
import com.example.todolist.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamService {
    TeamRepository teamRepository;
    TeamLeaderRepository teamLeaderRepository;
    ProjectRepository projectRepository;
    public void createTeam(UUID project_id,UUID teamLeader_id, TeamDTO teamDTO){
        TeamLeader teamLeader = teamLeaderRepository.findTeamLeaderById(teamLeader_id);
        if (teamLeader == null){
            throw new ApiException("invalid");
        }
        Project project = projectRepository.findProjectById(project_id);
        if (project == null){
            throw new ApiException("invalid");
        }
        Team team = new Team(null,teamDTO.getTeam_name(),project,teamLeader,null,null);
        teamRepository.save(team);
    }
}
