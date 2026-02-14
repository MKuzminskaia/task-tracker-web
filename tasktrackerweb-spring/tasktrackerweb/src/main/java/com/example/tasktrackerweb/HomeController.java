package com.example.tasktrackerweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final TaskService taskService;

    public  HomeController (TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.sortCopyTasks());
        return "index";
    }

    @PostMapping("/tasks")
    public String addTask( @RequestParam String title,
                           @RequestParam Priority priority){

        if(priority == null)
            priority = Priority.MEDIUM;
        if(!title.trim().isEmpty() && title.trim().length() <= 60)
            taskService.add(title.trim(),priority);

        return "redirect:/";
    }

    @PostMapping("/tasks/done")
    public String markTaskDone(@RequestParam int id){
        taskService.markDone(id);

        return "redirect:/";
    }

    @PostMapping("/tasks/process")
    public String markTaskInProcess(@RequestParam int id){
        taskService.markInProcess(id);
        return "redirect:/";
    }


    @PostMapping("/tasks/delete")
    public String deleteTask(@RequestParam int id){
        taskService.deleteTask(id);

        return "redirect:/";
    }

}