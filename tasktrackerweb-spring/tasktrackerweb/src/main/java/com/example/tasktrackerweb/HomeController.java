package com.example.tasktrackerweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private TaskService taskService;

    public  HomeController (TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        return "index";
    }

    @PostMapping("/tasks")
    public String addTask( @RequestParam String title,
                           @RequestParam Priority priority){

        if(!title.trim().isEmpty())
            taskService.add(title.trim(),priority);


        System.out.println(taskService.getAll());

        return "redirect:/";
    }


}