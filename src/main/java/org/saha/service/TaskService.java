package org.saha.service;

import java.util.List;

public interface TaskService {
    void createTask(String name);
    void updateTask(int id,String newName);

    void deleteTask(int id);
    List<String> listTasks();

}
