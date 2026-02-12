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
        model.addAttribute("tasks", taskService.getAll());
        return "index";
    }

    @PostMapping("/tasks")
    public String addTask( @RequestParam String title,
                           @RequestParam Priority priority){

        if(!title.trim().isEmpty())
            taskService.add(title.trim(),priority);

        for(int i = 0; i < taskService.getAll().size();  i++)
            System.out.println(taskService.getAll().get(i));

        return "redirect:/";
    }

    @PostMapping("/tasks/done")
    public String markTaskDone(@RequestParam int id){
        taskService.markDone(id);

        for(int i = 0; i < taskService.getAll().size();  i++)
            System.out.println(taskService.getAll().get(i));

        return "redirect:/";
    }


    @PostMapping("/tasks/delete")
    public String deleteTask(@RequestParam int id){
        taskService.deleteTask(id);

        for(int i = 0; i < taskService.getAll().size();  i++)
            System.out.println(taskService.getAll().get(i));

        return "redirect:/";
    }

}