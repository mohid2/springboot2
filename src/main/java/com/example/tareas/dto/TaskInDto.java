package com.example.tareas.dto;


import lombok.Data;

import java.time.LocalDate;
@Data
public class TaskInDto {
    private String title;
    private String description;

    private LocalDate estimatedCompletionDate;
}
