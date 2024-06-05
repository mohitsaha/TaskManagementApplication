package org.saha.service;


import org.junit.Before;
import org.junit.Test;
import org.saha.service.TaskService;
import org.saha.service.TaskServiceImpl;
import static org.junit.Assert.*;

public class TaskServiceTest {
    private TaskService taskService;

    @Before
    public void setUp(){
        taskService = new TaskServiceImpl();
    }

    @Test
    public void testCreateTask(){
        taskService.createTask("Test Task");
        assertEquals(1,taskService.listTasks().size());
    }
}
