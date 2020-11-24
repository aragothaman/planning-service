package com.planningboard.planningservice.dataacess;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.io.Serializable;

public class TaskKey implements Serializable {
    String planId;
    String taskId ;

    public TaskKey() {
    }

    @DynamoDBHashKey(attributeName = "plan_id")
    public String getPlanId() {
        return this.planId;
    }

    @DynamoDBRangeKey(attributeName = "task_id")
    public String getTaskId() {
        return this.taskId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }
}
