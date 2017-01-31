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
    public List<Task> getTaskOfProject(@RequestParam(value = "projectId", required = false) Integer projectId) {
        if (projectId != null) {
            return taskService.findTaskByProjectId(projectId);
        }

        return taskService.findAllTask();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable("id") int id) {
        return new ResponseEntity<>(taskService.findTaskById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskForm taskForm) {
       return new ResponseEntity<>(taskService.save(taskForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> edit(@RequestBody TaskForm taskForm) {
        return new ResponseEntity<>(taskService.update(taskForm), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        taskService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}