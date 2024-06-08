package org.saha.manager;

import com.google.inject.Inject;
import org.saha.binding.Email;
import org.saha.binding.Sms;
import org.saha.service.NotificationService;
import org.saha.service.TaskService;

public class TaskManager {
    private final TaskService taskService;
    @Inject
    public TaskManager(TaskService taskService){
        this.taskService = taskService;
    }

    public void performTaskOperations(){
        taskService.createTask("sample Task");
    }



}
