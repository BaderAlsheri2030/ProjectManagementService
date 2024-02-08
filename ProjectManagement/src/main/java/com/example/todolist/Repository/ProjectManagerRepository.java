package com.example.todolist.Repository;

import com.example.todolist.Model.ProjectManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ProjectManagerRepository extends JpaRepository<ProjectManager, UUID> {
    ProjectManager findProjectManagerById(UUID uuid);
}
