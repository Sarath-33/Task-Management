package com.withsarath.mapper;

import com.withsarath.domain.CreateTaskRequest;
import com.withsarath.domain.UpdateTaskRequest;
import com.withsarath.domain.dto.CreateTaskRequestDto;
import com.withsarath.domain.dto.TaskDto;
import com.withsarath.domain.dto.UpdateTaskRequestDto;
import com.withsarath.domain.entity.Task;

public interface TaskMapper {
    CreateTaskRequest fromDto(CreateTaskRequestDto dto);

    TaskDto toDto(Task task);
    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);
}
