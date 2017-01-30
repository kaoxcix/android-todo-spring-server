package com.ninekao.rest_service.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by arms on 25/10/2559.
 */
@Data
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue
    public int id;
    public String name;
    public Date createdDate;
    public Date updatedDate;
}
