package org.saha.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.saha.binding.Email;
import org.saha.binding.Sms;
import org.saha.manager.TaskManager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
public class NotificationServiceTest {

    private TaskManager taskManager;
    private EmailNotificationService emailServiceMock;

    private TaskService taskServiceMock;

    private SmsNotificationService smsServiceMock;

    @BeforeEach
    public void setUp(){
        //create mock instance of NotificationService
        emailServiceMock = mock(EmailNotificationService.class);
        smsServiceMock = mock(SmsNotificationService.class);
        taskServiceMock = mock(TaskServiceImpl.class);
        Injector injector = Guice.createInjector(binder -> {
            binder.bind(NotificationService.class).annotatedWith(Email.class).toInstance(emailServiceMock);
            binder.bind(NotificationService.class).annotatedWith(Sms.class).toInstance(smsServiceMock);
            binder.bind(TaskService.class).toInstance(taskServiceMock);
        });

        taskManager = injector.getInstance(TaskManager.class);
    }

    @Test
    public void testCreateTask(){
        taskManager.createTask("Test task");

        //verify that notification were sent
        verify(emailServiceMock).sendNotification("New task created: Test task");
        verify(smsServiceMock).sendNotification("New task created: Test task");
    }
}
