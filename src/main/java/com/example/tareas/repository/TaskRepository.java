package com.example.tareas.repository;

import com.example.tareas.entity.Task;
import com.example.tareas.entity.Taskstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    public List<Task> findAllTasksByStatus(Taskstatus taskstatus);
    @Modifying
    @Query(value = "UPDATE TASKS SET completed=true WHERE id=:id",nativeQuery = true)
    public void updateTaskCompleted(@Param("id") Long id);

}
