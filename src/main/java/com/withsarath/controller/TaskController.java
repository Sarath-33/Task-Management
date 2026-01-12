package com.withsarath.controller;

import com.withsarath.domain.CreateTaskRequest;
import com.withsarath.domain.UpdateTaskRequest;
import com.withsarath.domain.dto.CreateTaskRequestDto;
import com.withsarath.domain.dto.TaskDto;
import com.withsarath.domain.dto.UpdateTaskRequestDto;
import com.withsarath.domain.entity.Task;
import com.withsarath.mapper.TaskMapper;
import com.withsarath.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper){
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto createTaskRequestDto
            ){
        CreateTaskRequest taskToCreate = taskMapper.fromDto(
                createTaskRequestDto
        );

        Task createdTask = taskService.createTask(taskToCreate);
        TaskDto createTaskDto = taskMapper.toDto(createdTask);
        return new ResponseEntity<>(createTaskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTask(){
        List<Task> tasks = taskService.listTask();
        List<TaskDto> taskDtoList = tasks.stream().map(taskMapper::toDto).toList();

        return ResponseEntity.ok(taskDtoList);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto){
           UpdateTaskRequest updateTaskRequest = taskMapper.fromDto(updateTaskRequestDto);

        Task updatedTask = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto taskMapperDto = taskMapper.toDto(updatedTask);
        return ResponseEntity.ok(taskMapperDto);

    }
    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId){
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }



}
