package test;

import com.example.task_management.model.Task;
import com.example.task_management.repository.TaskRepository;
import com.example.task_management.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TaskServiceTest {

    @Test
    public void testGetAllTasks() {
        TaskRepository taskRepository = mock(TaskRepository.class);
        TaskService taskService = new TaskService(taskRepository);

        when(taskRepository.findAll()).thenReturn(List.of(new Task()));

        List<Task> tasks = taskService.getAllTasks();
        assertEquals(1, tasks.size());
    }
}
