package com.ninekao.rest_service.controller.task;

import lombok.Data;

/**
 * Created by Rabbit on 29-Oct-16.
 */

@Data
public class TaskForm {

    private int id;
    private String name;
    private int projectId;

}
