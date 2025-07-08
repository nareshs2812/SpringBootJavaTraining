package com.example.todo_task_tracker.service;

import com.example.todo_task_tracker.model.Task;
import com.example.todo_task_tracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public List<Task> addTasks(Task newTask) {
        taskRepository.save(newTask);
        return taskRepository.findAll();
    }

    public String updateTask(int id, Task updateTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setTitle(updateTask.getTitle());
            task.setDescription(updateTask.getDescription());
            task.setStatus(updateTask.getStatus());
            taskRepository.save(task);
            return "Task with id " + id + " was updated successfully";
        }
        return "Task with id " + id + " was not found to update";
    }

    public String deleteTask(int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return "Task with id " + id + " was deleted successfully";
        }
        return "Task with id " + id + " was not found to delete";
    }

    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }
}
