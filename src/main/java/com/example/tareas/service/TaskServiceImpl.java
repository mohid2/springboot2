package com.example.tareas.service;

import com.example.tareas.dto.TaskInDto;
import com.example.tareas.entity.Task;
import com.example.tareas.entity.Taskstatus;
import com.example.tareas.mapper.TaskInDtoToTask;
import com.example.tareas.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repository;
    private final TaskInDtoToTask taskInDtoToTask;

    public TaskServiceImpl(TaskRepository repository, TaskInDtoToTask taskInDtoToTask) {
        this.repository = repository;
        this.taskInDtoToTask = taskInDtoToTask;
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
    public Task createTask(TaskInDto taskInDto) {
        Task task=taskInDtoToTask.map(taskInDto);
        return  repository.save(task);
    }

    @Override
    public List<Task> getTaskByStatus(Taskstatus taskstatus) {
        return this.repository.findAllTasksByStatus(taskstatus);
    }

    @Override
    @Transactional
    public ResponseEntity<Void>  updateTaskAscompleted(Long id) {
        if(repository.existsById(id)){
            repository.updateTaskCompleted(id);
           return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteOneTask(Long id) {
        if(repository.existsById(id)){
             repository.deleteById(id);
             return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
