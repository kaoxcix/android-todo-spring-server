package com.ninekao.rest_service.domain.service;

import com.ninekao.rest_service.controller.project.ProjectForm;
import com.ninekao.rest_service.domain.entity.Project;
import com.ninekao.rest_service.domain.entity.Task;
import com.ninekao.rest_service.domain.repository.ProjectRepository;
import com.ninekao.rest_service.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Project> findAllProject() {
        return projectRepository.findAll();
    }

    public Project findProjectById(int id) {
        return projectRepository.findOne(id);
    }

    public List<Task> findTaskByProjectId(int id) {
        return projectRepository.findOne(id).getTasks();
    }

    public Project save(ProjectForm projectForm) {
        Date date = Calendar.getInstance().getTime();
        Project project = new Project();
        project.setName(projectForm.getName());
        project.setCreatedDate(date);
        project.setUpdatedDate(date);
        project.setTasks(new ArrayList<Task>());
        return projectRepository.save(project);
    }

    public Project update(ProjectForm projectForm) {
        Project project = projectRepository.findOne(projectForm.getId());
        project.setName(projectForm.getName());
        project.setUpdatedDate(Calendar.getInstance().getTime());
        return projectRepository.save(project);
    }

    public void delete(int projectId) {
        projectRepository.delete(projectId);
    }
    
}
