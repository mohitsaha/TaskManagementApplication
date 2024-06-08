package org.saha.service;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.saha.binding.Email;
import org.saha.binding.Sms;
import org.saha.manager.NotificationManager;
import org.saha.manager.TaskManager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
public class NotificationServiceTest {
    private EmailNotificationService emailServiceMock;
    private SmsNotificationService smsServiceMock;

    private NotificationManager notificationManager;
    @Before
    public void setUp(){
        //create mock instance of NotificationService
        emailServiceMock = mock(EmailNotificationService.class);
        smsServiceMock = mock(SmsNotificationService.class);
        Injector injector = Guice.createInjector(binder -> {
            binder.bind(NotificationService.class).annotatedWith(Email.class).toInstance(emailServiceMock);
            binder.bind(NotificationService.class).annotatedWith(Sms.class).toInstance(smsServiceMock);
        });

        notificationManager = injector.getInstance(NotificationManager.class);
    }

    @Test
    public void testCreateTask(){
        notificationManager.createTask("Test task");

        //verify that notification were sent
        verify(emailServiceMock).sendNotification("New task created: Test task");
        verify(smsServiceMock).sendNotification("New task created: Test task");
    }
}
