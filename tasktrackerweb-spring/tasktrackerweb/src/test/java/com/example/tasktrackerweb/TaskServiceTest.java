package com.example.tasktrackerweb;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void add_shouldAddTaskWithNewStatusAndGivenPriority() {
        // Arrange
        TaskService service = new TaskService();

        // Act
        service.add("Test1 task", Priority.HIGH);

        // Assert
        assertEquals(1, service.getAll().size(), "After add() there should be 1 task");

        Task t = service.getAll().get(0);
        assertEquals("Test1 task", t.getTitle());
        assertEquals(Priority.HIGH, t.getPriority());
        assertEquals(Status.NEW, t.getStatus());
    }

    @Test
    void markInProcess_shouldMarkInProcess() {
        // Arrange
        TaskService service = new TaskService();

        // Act
        service.add("Test2 task", Priority.MEDIUM);
        int id = service.getAll().get(0).getId();
        service.markInProcess(id);

        // Assert

        Task t = service.getAll().get(0);

        assertEquals(Status.IN_PROCESS, t.getStatus(), "After markInProcess() there should be status IN_PROCESS");
    }

    @Test
    void markDone_shouldMarkDone() {
        // Arrange
        TaskService service = new TaskService();

        // Act
        service.add("Test3 task", Priority.HIGH);
        int id = service.getAll().get(0).getId();
        service.markDone(id);
        // Assert

        Task t = service.getAll().get(0);

        assertEquals(Status.DONE, t.getStatus(), "After markDone() there should be status DONE");
    }

    @Test
    void deleteTask_shouldDeleteTask() {
        // Arrange
        TaskService service = new TaskService();

        // Act
        service.add("Test4 task1", Priority.CRITICAL);
        service.add("Test4 task2", Priority.LOW);
        int id = service.getAll().get(1).getId();
        service.deleteTask(id);

        // Assert

        assertEquals(1, service.getAll().size(), "After deleteTask() there should be size 1");
        assertEquals("Test4 task1", service.getAll().get(0).getTitle(), "There should be task with name 'Test4 task1'");
    }

    @Test
    void sortCopyTasks_shouldSortCopyTasks(){
        // Arrange

        TaskService service = new TaskService();

        // Act

        service.add("Test5_task1", Priority.LOW);
        service.add("Test5_task2", Priority.HIGH);
        service.add("Test5_task3", Priority.MEDIUM);
        service.add("Test5_task4", Priority.LOW);
        service.add("Test5_task5", Priority.CRITICAL);
        service.add("Test5_task6", Priority.HIGH);
        service.add("Test5_task7", Priority.MEDIUM);

        int id = service.getAll().get(0).getId();
        service.markInProcess(id);

        id = service.getAll().get(3).getId();
        service.markDone(id);

        ArrayList<Task> resultService = service.sortCopyTasks();
        // Assert

        assertEquals("Test5_task3", resultService.get(0).getTitle(), "After sortCopyTasks() should be Test5_task3");
        assertEquals("Test5_task7", resultService.get(1).getTitle(), "After sortCopyTasks() should be Test5_task7");
        assertEquals("Test5_task2", resultService.get(2).getTitle(), "After sortCopyTasks() should be Test5_task2");
        assertEquals("Test5_task6", resultService.get(3).getTitle(), "After sortCopyTasks() should be Test5_task6");
        assertEquals("Test5_task5", resultService.get(4).getTitle(), "After sortCopyTasks() should be Test5_task5");
        assertEquals("Test5_task1", resultService.get(5).getTitle(), "After sortCopyTasks() should be Test5_task1");
        assertEquals("Test5_task4", resultService.get(6).getTitle(), "After sortCopyTasks() should be Test5_task4");

    }
}