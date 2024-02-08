package com.example.todolist.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String teamName;


    @ManyToOne
    @JoinColumn(columnDefinition = "project_id",referencedColumnName = "id")
    @JsonIgnore
    private Project project;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "team")
    @PrimaryKeyJoinColumn
    private TeamLeader teamLeader;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "team")
    private Set<TaskList> taskLists;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "team")
    private Set<Employee> employees;
}