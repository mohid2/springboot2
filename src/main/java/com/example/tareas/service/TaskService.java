package com.example.tareas.service;

import com.example.tareas.dto.TaskInDto;
import com.example.tareas.entity.Task;
import com.example.tareas.entity.Taskstatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();
    ResponseEntity<Task> getOneTask(Long id);

    Task createTask(TaskInDto taskInDto);

    List<Task>getTaskByStatus(Taskstatus taskstatus);

    void updateTaskAscompleted(Long id);

}
