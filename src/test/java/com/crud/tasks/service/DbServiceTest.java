package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class DbServiceTest {

    @InjectMocks
    private DbService dbService;

    @Mock
    private TaskRepository taskRepository;

    @Test
    void testGetAllTasks() {
        //Given
        List<Task> tasks = List.of(
                new Task(1L, "Task 1", "Content 1"),
                new Task(2L, "Task 2", "Content 2")
        );
        when(taskRepository.findAll()).thenReturn(tasks);

        //When
        List<Task> result = dbService.getAllTasks();

        //Then
        assertNotNull(result.get(0));
        assertEquals(tasks, result);
        assertEquals(tasks.size(), result.size());
        assertEquals("Task 1", result.get(0).getTitle());
        assertEquals("Content 1", result.get(0).getContent());
        assertEquals("Task 2", result.get(1).getTitle());
        assertEquals("Content 2", result.get(1).getContent());
    }

    @Test
    void testGetTaskById() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "Task 1", "Content 1");
        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        //When
        Task result = dbService.getTask(1L);

        //Then
        assertNotNull(result);
        assertEquals("Task 1", result.getTitle());
        assertEquals("Content 1", result.getContent());
        assertNotEquals("oo", result.getTitle());
    }

    @Test
    void testSaveTask() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "Task 1", "Content 1");
        when(taskRepository.save(task)).thenReturn(task);

        //When
        Task result = dbService.saveTask(task);

        //Then
        assertNotNull(result);
        assertEquals( 1L , result.getId());
        assertEquals("Task 1", result.getTitle());
        assertEquals("Content 1", result.getContent());
    }

    @Test
    void testDeleteTask() throws TaskNotFoundException {
        // When
        dbService.deleteTask(1L);

        // Then
        verify(taskRepository).deleteById(1L);

    }






}