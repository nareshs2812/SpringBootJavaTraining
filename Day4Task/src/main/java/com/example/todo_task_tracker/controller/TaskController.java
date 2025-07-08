package com.example.todo_task_tracker.controller;

import com.example.todo_task_tracker.model.Task;
import com.example.todo_task_tracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskservice;

    @GetMapping("/")
    public List<Task> getTasks(){
        return taskservice.getTasks();
    }

    @PutMapping("{id}")
    public String updateTask(@PathVariable int id, @RequestBody Task task){
        return taskservice.updateTask(id,task);
    }

    @PostMapping("/")
    public List<Task> addTasks(@RequestBody Task task){
        return taskservice.addTasks(task);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable int id) {
        return taskservice.getTaskById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        return taskservice.deleteTask(id);
    }


}
