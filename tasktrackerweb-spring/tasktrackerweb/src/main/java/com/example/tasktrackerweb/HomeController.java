package com.example.tasktrackerweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                           @RequestParam(required = false) Priority priority,
                           RedirectAttributes redirectAttributes){
        String trimmedTitle = title == null ? "" : title.trim();

        if(trimmedTitle.isEmpty())
            redirectAttributes.addFlashAttribute("error", "Task title is empty");
        else if (trimmedTitle.length() >= 60)
            redirectAttributes.addFlashAttribute("error", "Task title is too long (max 60)");
        else {
            if(priority == null) priority = Priority.MEDIUM;
            taskService.add(trimmedTitle, priority);
            redirectAttributes.addFlashAttribute("msg", "Added new task ");
        }

        return "redirect:/";
    }

    @PostMapping("/tasks/done")
    public String markTaskDone(@RequestParam int id,
                               RedirectAttributes redirectAttributes){
        if (taskService.markDone(id))
            redirectAttributes.addFlashAttribute("msg", "Task marked as Done successful");
        else
            redirectAttributes.addFlashAttribute("error", "Task didn't marked as Done");
        return "redirect:/";
    }

    @PostMapping("/tasks/process")
    public String markTaskInProcess(@RequestParam int id,
                                    RedirectAttributes redirectAttributes){
        if(taskService.findById(id) == null)
            redirectAttributes.addFlashAttribute("error", "Task didn't found");
        else if (taskService.findById(id).getStatus() == Status.DONE)
            redirectAttributes.addFlashAttribute("error", "Task already marked as completed, you can't set status 'in process'");
        else if (taskService.markInProcess(id))
            redirectAttributes.addFlashAttribute("msg", "Task marked as In Process successful");
        else
            redirectAttributes.addFlashAttribute("error", "Task didn't marked as In Process");
        return "redirect:/";
    }


    @PostMapping("/tasks/delete")
    public String deleteTask(@RequestParam int id,
                             RedirectAttributes redirectAttributes){
        if(taskService.deleteTask(id))
            redirectAttributes.addFlashAttribute("msg", "Task deleted successful");
        else
            redirectAttributes.addFlashAttribute("error", "Task didn't delete");

        return "redirect:/";
    }

}