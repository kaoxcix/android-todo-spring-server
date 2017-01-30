package com.ninekao.rest_service.domain.service;

import com.ninekao.rest_service.controller.project.ProjectForm;
import com.ninekao.rest_service.domain.entity.Project;
import com.ninekao.rest_service.domain.repository.ProjectRepository;
import com.ninekao.rest_service.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    TaskRepository taskRepository;
    
    public List<Project> findAllProject() {
        return projectRepository.findAll();
    }
    
    public Project save(ProjectForm projectForm) {
        Date date = Calendar.getInstance().getTime();
        Project project = new Project();
        project.setName(projectForm.getName());
        project.setCreatedDate(date);
        project.setUpdatedDate(date);
        Project projectSaved = projectRepository.save(project);
        return projectSaved;
    }

    public Project findProjectById(int id) {
        Project project = projectRepository.findOne(id);
        return project;
    }

    public Project update(ProjectForm projectForm) {
        Project project = projectRepository.findOne(projectForm.getId());
        project.setName(projectForm.getName());
        project.setUpdatedDate(Calendar.getInstance().getTime());
        Project projectUpdated = projectRepository.save(project);
        return projectUpdated;
    }
//
//    public Map<Integer, Integer> calcRemainingTaskNumber(List<Project> projectList) {
//        Map<Integer, Integer> remainingTaskNumberMap = new HashMap();
//        for(Project project : projectList) {
//            int taskCount = 0;
//            for(Task task : project.getTaskList()) {
//                if(!task.isStatus()) {
//                    taskCount++;
//                }
//            }
//            remainingTaskNumberMap.put(project.getId(), taskCount);
//        }
//        return remainingTaskNumberMap;
//    }
//
    public void delete(int projectId) {
        projectRepository.delete(projectId);
    }
    
}
