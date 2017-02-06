package com.ninekao.rest_service.domain.service;

import com.ninekao.rest_service.controller.task.TaskForm;
import com.ninekao.rest_service.domain.entity.Project;
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
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findTaskByProjectId(int projectId){
        return taskRepository.findAllByProjectId(projectId);
    }

    public List<Task> findAllTask() {
        return taskRepository.findAll();
    }

    public Task findTaskById(int id) {
        return taskRepository.findOne(id);
    }

    public Task save(TaskForm taskForm) {
        Date date = Calendar.getInstance().getTime();
        Project project = projectRepository.getOne(taskForm.getProjectId());

        Task task = new Task();
        task.setName(taskForm.getName());
        task.setStatus(false);
        task.setCreatedDate(date);
        task.setUpdatedDate(date);
        task.setProject(project);

        projectRepository.save(project);

        return taskRepository.save(task);
    }

    public Task update(TaskForm taskForm) {
        Task task = taskRepository.findOne(taskForm.getId());
        task.setName(taskForm.getName());
        task.setStatus(taskForm.getStatus());
        return taskRepository.save(task);
    }

    public void delete(int taskId) {
        taskRepository.delete(taskId);
    }

    public List<Task> deleteByProjectId(int projectId) {
        return taskRepository.deleteByProjectId(projectId);
    }
}
