package com.example.taskapi.services;

import com.example.taskapi.models.Task;
import com.example.taskapi.models.TaskExecution;
import com.example.taskapi.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public Task executeTask(String id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            try {
                Process process = Runtime.getRuntime().exec(task.getCommand());
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder output = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append("\n");
                }
                process.waitFor();
                task.getTaskExecutions().add(new TaskExecution(System.currentTimeMillis(), System.currentTimeMillis(), output.toString()));
                return taskRepository.save(task);
            } catch (Exception e) {
                throw new RuntimeException("Error executing task: " + e.getMessage());
            }
        }
        throw new RuntimeException("Task not found");
    }

    public List<Task> searchTasksByName(String name) {
        return taskRepository.findByNameContainingIgnoreCase(name);
    }
}