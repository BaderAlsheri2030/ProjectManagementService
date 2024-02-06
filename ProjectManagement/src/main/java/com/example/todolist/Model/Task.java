package com.example.todolist.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(columnDefinition = "varchar(150) not null unique")
    private String taskName;
    @Column(columnDefinition = "varchar(300) not null")
    private String description;
    @Column(columnDefinition = "varchar(6) not null check(priority='Low' or priority='Medium' or priority='High')")
    private String priority;
    @Column(columnDefinition = "varchar(10) not null check(status='Incomplete' or status='Completed' or status='Delayed')")
    private String status;
    @Column(columnDefinition = "DATE not null")
    private LocalDate startDate;
    @Column(columnDefinition = "DATE not null")
    private LocalDate dueDate;

    @ManyToOne
    @JoinColumn(columnDefinition = "taskList_id",referencedColumnName = "id")
    @JsonIgnore
    private TaskList taskList;

    @ManyToOne
    @JoinColumn(columnDefinition = "employee_id",referencedColumnName = "id")
    @JsonIgnore
    private Employee employee;
}