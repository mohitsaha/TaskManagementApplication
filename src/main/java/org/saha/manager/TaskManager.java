package org.saha.manager;

import com.google.inject.Inject;
import org.saha.binding.Email;
import org.saha.binding.Sms;
import org.saha.service.NotificationService;
import org.saha.service.TaskService;

public class TaskManager {
    private final TaskService taskService;
    private final NotificationService smsService;

    private final NotificationService emailService;


    @Inject
    public TaskManager(TaskService taskService, @Email NotificationService emailService, @Sms NotificationService smsService){
        this.taskService = taskService;
        this.smsService = smsService;
        this.emailService = emailService;
    }

    public void performTaskOperations(){
        taskService.createTask("sample Task");
    }

    public void createTask(String taskDetails){
        emailService.sendNotification("New task created:" + taskDetails);
        smsService.sendNotification("New task created: " + taskDetails);
    }

}
