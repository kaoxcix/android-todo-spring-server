package com.ninekao.rest_service.domain.service;

import com.ninekao.rest_service.controller.task.TaskForm;
import com.ninekao.rest_service.domain.entity.Task;
import com.ninekao.rest_service.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

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
        Task task = new Task();
        task.setName(taskForm.getName());
        task.setStatus(false);
        task.setCreatedDate(date);
        task.setUpdatedDate(date);
        return taskRepository.save(task);
    }

    public Task update(TaskForm taskForm) {
        Task task = taskRepository.findOne(taskForm.getId());
        task.setStatus(taskForm.getStatus());
        return taskRepository.save(task);
    }

    public void delete(int taskId) {
        taskRepository.delete(taskId);
    }
}
