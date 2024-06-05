package org.saha.module;

import com.google.inject.AbstractModule;
import org.saha.service.TaskService;
import org.saha.service.TaskServiceImpl;

public class AppModule extends AbstractModule {
    @Override
    protected void configure(){
        bind(TaskService.class).to(TaskServiceImpl.class);
    }
    //Guice module were binding is done

}
