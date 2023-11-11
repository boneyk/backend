package com.example.demo.controller;


import com.example.demo.dao.TaskDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


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
}
