package com.withsarath.domain.dto;

import com.withsarath.domain.entity.TaskPriority;
import com.withsarath.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority,
        TaskStatus status
) {
}
