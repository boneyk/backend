package com.example.demo.dao;


import com.example.demo.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDAO {
    private List<Task> tasks;
    {
        tasks = new ArrayList<>();
        tasks.add(new Task(1,"Уборка", "Навести порядок"));
        tasks.add(new Task(2,"Встреча", "У кафе в 17:00"));
        tasks.add(new Task(3,"Матанализ", "Разобраться с поверхсностными интегралами"));
        tasks.add(new Task(4,"Бекэнд", "Разобраться с Spring"));
    }

    public List<Task> index(){
        return tasks;
    }
    public Task show(int id){
        return tasks.stream().filter(issue -> issue.getId() == id).findAny().orElse(null);
    }
}
