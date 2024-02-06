package com.example.todolist.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String projectName;
    @Column(columnDefinition = "DATE not null")
    private LocalDate startDate;
    @Column(columnDefinition = "DATE not null")
    private LocalDate dueDate;
    @Column(columnDefinition = "varchar(100) not null")
    private String projectStatus;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "project")
    private Set<Team> teams;
}
