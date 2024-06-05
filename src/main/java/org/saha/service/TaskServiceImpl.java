package org.saha.service;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final List<String> tasks = new ArrayList<>();

    @Override
    public void createTask(String name) {
        tasks.add(name);
    }

    @Override
    public void updateTask(int id, String newName) {
        tasks.set(id,newName);
    }

    @Override
    public void deleteTask(int id) {
        tasks.remove(id);
    }

    @Override
    public List<String> listTasks() {
        return tasks;
    }
}
