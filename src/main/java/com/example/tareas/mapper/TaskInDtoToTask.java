package com.example.tareas.mapper;

import com.example.tareas.dto.TaskInDto;
import com.example.tareas.entity.Task;
import com.example.tareas.entity.Taskstatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TaskInDtoToTask implements IMapper<TaskInDto, Task> {
    @Override
    public Task map(TaskInDto in) {
        Task task=new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEstimatedCompletionDate(in.getEstimatedCompletionDate());
        task.setCreationDate(LocalDate.now());
        task.setCompleted(false);
        task.setStatus(Taskstatus.ON_TIME);
        return task;
    }
}
