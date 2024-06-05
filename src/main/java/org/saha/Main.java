package org.saha;


import com.google.inject.Guice;
import com.google.inject.Injector;
import org.saha.manager.TaskManager;
import org.saha.module.AppModule;

public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AppModule());

        TaskManager taskManager = injector.getInstance(TaskManager.class);

        taskManager.performTaskOperations();


    }
}