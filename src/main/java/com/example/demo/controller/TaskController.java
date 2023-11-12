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
    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id") int id){
        model.addAttribute("task",taskDAO.show(id));
        return "task/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("issue") Task issue, @PathVariable("id") int id){
        taskDAO.update(id,issue);
        return "redirect:/task";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        taskDAO.delete(id);
        return "redirect:/task";
    }
}
