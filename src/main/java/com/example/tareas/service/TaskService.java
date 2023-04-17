package com.example.tareas.service;

import com.example.tareas.entity.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();
    ResponseEntity<Task> getOneTask(Long id);

    Task createTask(Task task);

}
