package com.crud.tasks.facade;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskFacade {

    private final DbService dbService;
    private final TaskMapper taskMapper;

    public List<TaskDto> fetchAllTasks() {
        List<Task> tasks = dbService.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    public TaskDto fetchTaskById(Long id) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(dbService.getTask(id));
    }

    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        Task savedTask = dbService.saveTask(task);
        return taskMapper.mapToTaskDto(savedTask);
    }

    public void deleteTask(Long taskId) {
        dbService.deleteTask(taskId);
    }
}
