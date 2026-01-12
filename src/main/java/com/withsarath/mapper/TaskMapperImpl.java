package com.withsarath.mapper;

import com.withsarath.domain.CreateTaskRequest;
import com.withsarath.domain.UpdateTaskRequest;
import com.withsarath.domain.dto.CreateTaskRequestDto;
import com.withsarath.domain.dto.TaskDto;
import com.withsarath.domain.dto.UpdateTaskRequestDto;
import com.withsarath.domain.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper{


    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto dto) {
        return new CreateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        if(null == task){
            return null;
        }
        return new TaskDto(
          task.getId(),
          task.getTitle(),
          task.getDescription(),
          task.getDue_date(),
          task.getPriority(),
          task.getStatus()
        );

    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(
                dto.title(),
                dto.description(),
                dto.dueDate(),
                dto.status(),
                dto.priority()
        );
    }
}
