package com.withsarath.domain;

import com.withsarath.domain.entity.TaskPriority;
import com.withsarath.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
