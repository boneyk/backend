package com.example.demo.controller;


import com.example.demo.dao.TaskDAO;
import com.example.demo.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/task")
public class TaskController{


    private final TaskDAO taskDAO;
    public TaskController(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("task",taskDAO.index());
        return "task/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("issue",taskDAO.show(id));
        return "task/show";
    }
    @GetMapping("/new")
    public String newTask(Model model){
        model.addAttribute("issue",new Task());
        return "task/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("issue") Task issue){
        TaskDAO.save(issue);
        return "redirect:/task";
    }
}
