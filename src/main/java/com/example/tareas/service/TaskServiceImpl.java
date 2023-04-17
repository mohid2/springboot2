package com.example.tareas.service;

import com.example.tareas.entity.Task;
import com.example.tareas.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> getAllTask() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Task> getOneTask(Long id) {
        if(repository.existsById(id)){
            Optional<Task> optionalTask=repository.findById(id);
            return ResponseEntity.ok(optionalTask.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public Task createTask(Task task) {
        if(repository.existsById(task.getId())){
            return null;
        }
        return  repository.save(task);
    }
}
