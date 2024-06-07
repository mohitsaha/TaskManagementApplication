package org.saha.module;

import com.google.inject.AbstractModule;
import org.saha.binding.Email;
import org.saha.binding.Sms;
import org.saha.service.*;

public class AppModule extends AbstractModule {
    @Override
    protected void configure(){
        bind(TaskService.class).to(TaskServiceImpl.class);
        bind(NotificationService.class).annotatedWith(Email.class).to(EmailNotificationService.class);
        bind(NotificationService.class).annotatedWith(Sms.class).to(SmsNotificationService.class);
    }
    //Guice module were binding is done

}
