package com.framwork.taskapi.controller;
import com.framwork.taskapi.model.Task;
import com.framwork.taskapi.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository){
        this.repository = repository;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Task getTask(@PathVariable long id){
        return repository.findById(id);
    }
    @PostMapping
    public Task createTask(@RequestBody Task task){
        return repository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task updatedTask){
        updatedTask.setId(id);
        return repository.save(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        repository.delete(id);
    }
}
