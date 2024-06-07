package org.saha;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.saha.manager.TaskManager;
import org.saha.module.AppModule;

//TODO add database use Stateless and STATEFUL Annotation
//TODO USE session FACTORY and EntityManager
//TODO implements KAFKA AS Streaming service
//TODO use Kubernetes and docker to deploy
//TODO use multiThreading

public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AppModule());

        TaskManager taskManager = injector.getInstance(TaskManager.class);

        taskManager.performTaskOperations();
        taskManager.createTask("Implemented notification feature");

        ///@Binding Annotatopn


    }
}