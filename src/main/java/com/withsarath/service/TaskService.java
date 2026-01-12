package com.withsarath.service;

import com.withsarath.domain.CreateTaskRequest;
import com.withsarath.domain.UpdateTaskRequest;
import com.withsarath.domain.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskService {
     Task createTask(CreateTaskRequest request);

     List<Task> listTask();

     Task updateTask(UUID taskId, UpdateTaskRequest request);
     void deleteTask(UUID taskId);
}
