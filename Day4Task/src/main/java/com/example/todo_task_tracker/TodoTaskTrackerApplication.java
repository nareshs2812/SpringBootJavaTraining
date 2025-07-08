package com.example.todo_task_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoTaskTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoTaskTrackerApplication.class, args);
		System.out.println(">>> Application started <<<");
	}

}
