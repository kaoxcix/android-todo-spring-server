package com.ninekao.rest_service.controller.project;

import com.ninekao.rest_service.domain.entity.Project;
import com.ninekao.rest_service.domain.entity.Task;
import com.ninekao.rest_service.domain.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProject() {

        List<Project> tasks = projectService.findAllProject();

        if (tasks.isEmpty()) {
            System.out.println("Project not found");
            return new ResponseEntity<List<Project>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Project>>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable("id") int id) {
        Project project = projectService.findProjectById(id);

        if (project == null) {
            System.out.println("Project with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<Task>> getTask(@PathVariable("id") int id) {
        List<Task> tasks = projectService.findTaskByProjectId(id);

        if (tasks.isEmpty()) {
            System.out.println("Task with project id " + id + " not found");
            return new ResponseEntity<List<Task>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Task>>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody ProjectForm projectForm) {
        return new ResponseEntity<Project>(projectService.save(projectForm), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> edit(@PathVariable("id") int id, @RequestBody ProjectForm projectForm) {
        Project project = projectService.findProjectById(id);

        if (project == null) {
            System.out.println("Project with id " + id + " not found");
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Project>(projectService.update(projectForm), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Project> delete(@PathVariable("id") int id) {

        Project project = projectService.findProjectById(id);

        if (project == null) {
            System.out.println("Unable to delete. Project with id " + id + " not found");
            return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }

        projectService.delete(id);
        return new ResponseEntity<Project>(HttpStatus.NO_CONTENT);
    }

}
