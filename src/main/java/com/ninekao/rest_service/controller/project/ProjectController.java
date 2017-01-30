package com.ninekao.rest_service.controller.project;

import com.ninekao.rest_service.domain.entity.Project;
import com.ninekao.rest_service.domain.entity.Task;
import com.ninekao.rest_service.domain.service.ProjectService;
import com.ninekao.rest_service.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Kabiz on 29/10/2559.
 */
@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Project> getAllProject() {
        return projectService.findAllProject();
    }

    @GetMapping("/{id}")
    public ResponseEntity getProject(@PathVariable("id") int id) {
        return new ResponseEntity(projectService.findProjectById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/tasks")
    public List<Task> getTask(@PathVariable("id") int id) {
        return taskService.findTaskByProjectId(id);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProjectForm projectForm) {
        return new ResponseEntity(projectService.save(projectForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity edit(@RequestBody ProjectForm projectForm) {
        return new ResponseEntity(projectService.update(projectForm), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int projectId) {
        projectService.delete(projectId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
