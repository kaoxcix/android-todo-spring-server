package com.ninekao.rest_service.controller.task;

import com.ninekao.rest_service.domain.entity.Task;
import com.ninekao.rest_service.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getTaskOfProject(@RequestParam(value = "projectId", required = false) Integer projectId) {
        List<Task> tasks;
        if (projectId != null) {
            tasks = taskService.findTaskByProjectId(projectId);
        } else {
            tasks = taskService.findAllTask();
        }

        if (tasks.isEmpty()) {
            System.out.println("Task not found");
            return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") int id) {
        Task task = taskService.findTaskById(id);

        if (task == null) {
            System.out.println("Task with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskForm taskForm) {
       return new ResponseEntity<Task>(taskService.save(taskForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> edit(@PathVariable("id") int id, @RequestBody TaskForm taskForm) {
        Task task = taskService.findTaskById(id);

        if (task == null) {
            System.out.println("Task with id " + id + " not found");
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        } else {
            taskForm.setId(id);
        }

        return new ResponseEntity<>(taskService.update(taskForm), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        Task task = taskService.findTaskById(id);

        if (task == null) {
            System.out.println("Task with id " + id + " not found");
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }

        taskService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}