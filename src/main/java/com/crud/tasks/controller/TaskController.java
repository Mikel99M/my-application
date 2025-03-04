package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return ResponseEntity.ok(taskMapper.mapToTaskDtoList(tasks));
    }

//    @GetMapping(value = "{taskId}")
//    public TaskDto getTaskById(@PathVariable long taskId) {
//        return new TaskDto(taskId, "test title", "test_content");
//    }

    @GetMapping(value = "{taskId}")
    public ResponseEntity getTask(@PathVariable Long taskId) throws TaskNotFoundException {
        return ResponseEntity.ok(taskMapper.mapToTaskDto(service.getTask(taskId)));
    }

    @DeleteMapping(value = "{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        service.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.mapToTask(taskDto);
        Task savedTask = service.saveTask(task);
        return ResponseEntity.ok(taskMapper.mapToTaskDto(savedTask));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
//        Task task = taskMapper.mapToTask(taskDto);
//        service.saveTask(task);
//        return ResponseEntity.ok().build();
        Task task = taskMapper.mapToTask(taskDto);
        Task savedTask = service.saveTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskMapper.mapToTaskDto(savedTask));
    }


//    private final DbService service;
//    private final TaskMapper taskMapper;
//
////    @RequestMapping(method = RequestMethod.GET, value = "")
//    @GetMapping
//    public List<TaskDto> getTasks() {
//        List<Task> tasks = service.getAllTasks();
//        return taskMapper.mapToTaskDtoList(tasks);
//    }
//
////    @GetMapping(value = "{taskId}")
////    public Task getTaskById(Long id) {
////        return service.getTaskById(id);
////    }
//
//    @GetMapping(value = "{taskId}")
//    public TaskDto getTask(Long taskId) {
//        return new TaskDto(1L, "test title", "test_content");
//    }
//
//    @DeleteMapping(value = "{taskId}")
//    public void deleteTask(Long taskId) {
//
//    }
//
//    @PutMapping(value = "{taskId}")
//    public TaskDto updateTask(TaskDto taskDto) {
//        return new TaskDto(1L, "Edited test title", "Test content");
//    }
//
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void createTask(@RequestBody TaskDto taskDto) {
//        Task task = taskMapper.mapToTask(taskDto);
//        service.saveTask(task);
//    }

}
