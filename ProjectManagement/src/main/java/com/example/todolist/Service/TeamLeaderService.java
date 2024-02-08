package com.example.todolist.Service;

import com.example.todolist.DTO.TeamLeaderDTO;
import com.example.todolist.Model.TeamLeader;
import com.example.todolist.Model.User;
import com.example.todolist.Repository.TeamLeaderRepository;
import com.example.todolist.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamLeaderService {
    TeamLeaderRepository teamLeaderRepository;
    UserRepository userRepository;
    public void registerTeamLeader(TeamLeaderDTO teamLeaderDTO){
        TeamLeader teamLeader = new TeamLeader(null,teamLeaderDTO.getFirstName(),teamLeaderDTO.getLastName(),"Team Leader",null,null);
        User user = new User(null,teamLeaderDTO.getUserName(),teamLeaderDTO.getPassword(),teamLeaderDTO.getEmail(),teamLeader.getRole(),teamLeader,null,null);
        teamLeader.setUser(user);
        teamLeaderRepository.save(teamLeader);
        userRepository.save(user);
    }
}
