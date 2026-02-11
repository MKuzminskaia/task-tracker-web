package com.example.tasktrackerweb;

public class Task {
    private int id;
    private String title;
    private Priority priority;
    private Status status;

    public Task(int id, String title, Priority priority) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = Status.NEW;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toString(){
        String output;
        output = " id: " + String.valueOf(this.id)  + "; Title:  " + this.title + "; Status:  " + String.valueOf(this.status) + "; Priority: " + String.valueOf(this.priority) ;
        return output;
    }
}
