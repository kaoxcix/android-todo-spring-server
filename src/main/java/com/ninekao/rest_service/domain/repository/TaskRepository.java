package com.ninekao.rest_service.domain.repository;

import com.ninekao.rest_service.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arms on 25/10/2559.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByProjectId(int projectId);
}
