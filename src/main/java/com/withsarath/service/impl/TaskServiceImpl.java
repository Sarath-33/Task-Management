package com.withsarath.service.impl;

import com.withsarath.domain.CreateTaskRequest;
import com.withsarath.domain.UpdateTaskRequest;
import com.withsarath.domain.entity.Task;
import com.withsarath.domain.entity.TaskStatus;
import com.withsarath.exception.TaskNotFoundException;
import com.withsarath.repository.TaskRepository;
import com.withsarath.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreateTaskRequest request){
        Instant now = Instant.now();
        Task newTask = new Task(
                null,
                request.title(),
                request.description(),
                request.dueDate(),
                TaskStatus.OPEN,
                request.priority(),
                now,
                now
        );
        return taskRepository.save(newTask);
    }

    @Override
    public List<Task> listTask() {
        return taskRepository.findAll(Sort.by(Sort.Direction.ASC, "created"));
    }

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest request) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException(taskId));

        existingTask.setTitle(request.title());
        existingTask.setDescription(request.description());
        existingTask.setDue_date(request.dueDate());
        existingTask.setPriority(request.priority());
        existingTask.setStatus(request.status());

        existingTask.setUpdated(Instant.now());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }
}
