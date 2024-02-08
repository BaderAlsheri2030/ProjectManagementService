package com.example.todolist.Repository;

import com.example.todolist.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeamRepository extends JpaRepository<Team, UUID> {
    Team findTeamById(UUID uuid);
}
