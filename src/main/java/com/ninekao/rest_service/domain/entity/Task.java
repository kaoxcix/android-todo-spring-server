package com.ninekao.rest_service.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by arms on 25/10/2559.
 */
@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue
    public int id;
    public String name;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    public Boolean status;
    public Date createdDate;
    public Date updatedDate;
}
