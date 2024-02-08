package com.example.todolist.Repository;

import com.example.todolist.Model.TeamLeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeamLeaderRepository extends JpaRepository<TeamLeader, UUID> {
    TeamLeader findTeamLeaderById(UUID uuid);
}
