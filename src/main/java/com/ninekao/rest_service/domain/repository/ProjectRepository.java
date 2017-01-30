package com.ninekao.rest_service.domain.repository;

import com.ninekao.rest_service.domain.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arms on 25/10/2559.
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
