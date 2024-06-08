package org.saha;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.saha.manager.NotificationManager;
import org.saha.manager.TaskManager;
import org.saha.module.NotificationModule;
import org.saha.module.TaskModule;

//TODO add database use Stateless and STATEFUL Annotation
//TODO USE session FACTORY and EntityManager
//TODO implements KAFKA AS Streaming service
//TODO use Kubernetes and docker to deploy
//TODO use multiThreading

public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new TaskModule());
        TaskManager taskManager = injector.getInstance(TaskManager.class);
        taskManager.performTaskOperations();

        Injector injector1 = Guice.createInjector(new NotificationModule());
        NotificationManager manager = injector1.getInstance(NotificationManager.class);
        manager.createTask("task is created");
        ///@Binding Annotatopn


    }
}