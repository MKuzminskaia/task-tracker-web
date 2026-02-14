package com.example.tasktrackerweb;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

@Service
public class TaskService {
    private final ArrayList<Task> tasks = new ArrayList<>();
    private int id = 0;

    public ArrayList<Task> getAll(){
        ArrayList <Task> copiedTasks = new ArrayList<>(this.tasks);
        return copiedTasks;
    }
    public ArrayList<Task> sortCopyTasks(){
        ArrayList <Task> result = new ArrayList<>(this.tasks);

        result.sort(Task::compareStatusPrio);
        return result;
    }

    public void add(String title, Priority priority){
        Task task = new Task(id++, title,priority);
        this.tasks.add(task);
    }

    public void markDone( int id){
        if (this.findById(id) != null) {
            this.findById(id).setStatus(Status.DONE);
        }
    }

    public void markInProcess( int id){
        if (this.findById(id) != null) {
            this.findById(id).setStatus(Status.IN_PROCESS);
        }
    }

    public void deleteTask( int id){
        if(this.findById(id) != null)
            this.tasks.remove(this.findById(id));
    }

    public Task findById(int id) {
        if (!this.tasks.isEmpty()){
            for (int i = 0; i < this.tasks.size(); i++) {
                if (this.tasks.get(i).getId() == id){
                    return this.tasks.get(i);
                }
            }
        }
        return null;
    }
}
