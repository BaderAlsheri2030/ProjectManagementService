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

public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        @Column(columnDefinition = "varchar(50) not null")
        private String firstName;
        @Column(columnDefinition = "varchar(50) not null")
        private String lastName;
        @Column
        private String role;

        @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
        private Set<Task> tasks;

        @ManyToOne
        @JoinColumn(columnDefinition = "team_id",referencedColumnName = "id")
        @JsonIgnore
        private Team team;

        @OneToOne
        @JoinColumn(name = "user_id",referencedColumnName = "id")
        @JsonIgnore
        private User user;
}