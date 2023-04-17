package com.example.tareas.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "creation_Date")
    private LocalDate creationDate;
    @Column(name = "estimated_Completion_Date")
    private LocalDate estimatedCompletionDate;
    private boolean completed;
    private Taskstatus status;
}
