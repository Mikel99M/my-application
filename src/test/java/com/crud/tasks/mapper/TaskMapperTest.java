package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void testMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "test", "testing mapToTask");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertNotNull(task);
        assertEquals(taskDto.getId(), task.getId());
        assertEquals("test", task.getTitle());
        assertEquals("testing mapToTask", task.getContent());

    }

    @Test
    void testMapToTaskDto() {
        //Given
        Task task = new Task(1L, "test", "testing mapToTaskDto");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertNotNull(taskDto);
        assertEquals(task.getId(), taskDto.getId());
        assertEquals("test", taskDto.getTitle());
        assertEquals("testing mapToTaskDto", taskDto.getContent());

    }

    @Test
    void testMapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "test1", "testing testMapToTaskDtoList");
        Task task2 = new Task(2L, "test2", "testing testMapToTaskDtoList");
        Task task3 = new Task(3L, "test3", "testing testMapToTaskDtoList");
        List<Task> list = List.of(task1, task2, task3);

        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(list);

        //Then
        assertNotNull(taskDtoList);
        assertEquals(3, taskDtoList.size());
        assertEquals(task1.getId(), taskDtoList.get(0).getId());
        assertEquals("test1", taskDtoList.get(0).getTitle());
        assertEquals("testing testMapToTaskDtoList", taskDtoList.get(0).getContent());
        assertEquals(task2.getId(), taskDtoList.get(1).getId());
        assertEquals("test2", taskDtoList.get(1).getTitle());
        assertEquals("testing testMapToTaskDtoList", taskDtoList.get(1).getContent());
        assertEquals(3L, taskDtoList.get(2).getId());

    }

}
