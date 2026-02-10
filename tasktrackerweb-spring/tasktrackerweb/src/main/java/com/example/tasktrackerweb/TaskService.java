package com.example.tasktrackerweb;

import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    private final ArrayList<Task> tasks = new ArrayList<>();

    public ArrayList<Task> getAll(){
        return this.tasks;
    }

    public void add(String title, Priority priority){
        Task task = new Task(this.tasks.size(), title,priority);
        this.tasks.add(task);
    }
}
