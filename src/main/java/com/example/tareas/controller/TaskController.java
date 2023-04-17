package com.example.tareas.controller;

import com.example.tareas.entity.Task;
import com.example.tareas.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTask(){
        return service.getAllTask();
    }
    @GetMapping("{id}")
    public ResponseEntity<Task> getOneTask(@PathVariable Long id){
        return service.getOneTask(id);
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return service.createTask(task);
    }
}
