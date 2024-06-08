package org.saha.manager;

import com.google.inject.Inject;
import org.saha.binding.Email;
import org.saha.binding.Sms;
import org.saha.module.NotificationModule;
import org.saha.service.NotificationService;

public class NotificationManager {
    private final NotificationService smsService;

    private final NotificationService emailService;

    @Inject
    NotificationManager(@Sms  NotificationService smsService, @Email NotificationService emailService){
        this.smsService = smsService;
        this.emailService = emailService;
    }

    public void createTask(String taskDetails){
        emailService.sendNotification("New task created: " + taskDetails);
        smsService.sendNotification("New task created: " + taskDetails);
    }
}
