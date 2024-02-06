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
public class TaskList {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    @ManyToOne
    @JoinColumn(columnDefinition = "team_id",referencedColumnName = "id")
    @JsonIgnore
    private Team team;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "taskList")
    private Set<Task> tasks;

}