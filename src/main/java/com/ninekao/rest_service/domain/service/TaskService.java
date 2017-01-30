package com.ninekao.rest_service.domain.service;

import com.ninekao.rest_service.controller.task.TaskForm;
import com.ninekao.rest_service.domain.entity.Task;
import com.ninekao.rest_service.domain.repository.ProjectRepository;
import com.ninekao.rest_service.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    public List<Task> findTaskByProjectId(int projectId){
        return taskRepository.findAllByProjectId(projectId);
    }
//    public Project findProjectByProjectId(int projectId) {
//        return projectRepository.findOne(projectId);
//    }
//
//    public Project findProjectByTaskId(int taskId) {
//        Task task = taskRepository.findOne(taskId);
//        return task.getProject();
//    }

    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    public Task findTaskById(int id) {
        Task task = taskRepository.findOne(id);
        return task;
    }

    public Task save(TaskForm taskForm) {
        Date date = Calendar.getInstance().getTime();
        Task task = new Task();
        task.setName(taskForm.getName());
        task.setProject(projectRepository.findOne(taskForm.getProjectId()));
        task.setStatus(false);
        task.setCreatedDate(date);
        task.setUpdatedDate(date);
        Task taskSaved = taskRepository.save(task);
        return taskSaved;
    }

    public Task updateTaskStatus(int taskId, boolean status) {
        Task task = taskRepository.findOne(taskId);
        task.setStatus(status);
        Task taskSaved = taskRepository.save(task);
        return taskSaved;
    }

    public void delete(int taskId) {
        taskRepository.delete(taskId);
    }
}
