package com.example.demo.dao;


import com.example.demo.model.Task;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskDAO {
    private static int count = 0;
    private static List<Task> tasks;
    {
        tasks = new ArrayList<>();
        tasks.add(new Task(++count,"Уборка", "Навести порядок"));
        tasks.add(new Task(++count,"Встреча", "У кафе в 17:00"));
        tasks.add(new Task(++count,"Матанализ", "Разобраться с поверхсностными интегралами"));
        tasks.add(new Task(++count,"Бекэнд", "Разобраться с Spring"));
    }

    public List<Task> index(){
        return tasks;
    }
    public static Task show(int id){
        return tasks.stream().filter(issue -> issue.getId() == id).findAny().orElse(null);
    }

    public static void save(Task task){
        task.setId(++count);
        tasks.add(task);
    }
    public static void update(int id, Task updatedTask){
        Task taskToBeUpdated;
        taskToBeUpdated = show(id);

        taskToBeUpdated.setTitle(updatedTask.getTitle());
        taskToBeUpdated.setDescription(updatedTask.getDescription());
    }

    public static void delete(int id){
        tasks.removeIf(t -> t.getId() == id);
    }

}
