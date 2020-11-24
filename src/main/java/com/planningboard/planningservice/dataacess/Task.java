package com.planningboard.planningservice.dataacess;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "Tasks")
public class Task {
    @Id
    TaskKey taskKey ;
    String taskDetails ;

    public Task() {
    }

    @DynamoDBHashKey(attributeName = "plan_id")
    public String getPlanId() {
        return taskKey.getPlanId();
    }

    @DynamoDBRangeKey(attributeName = "task_id")
    public String getTaskId() {
        return this.taskKey.getTaskId();
    }

    @DynamoDBAttribute(attributeName = "task_details")
    public String getTaskDetails() {
        return taskDetails;
    }

    public void setPlanId(String planId) {
        if(taskKey == null){
            this.taskKey = new TaskKey();
        }
        this.taskKey.setPlanId(planId);
    }

    public void setTaskId(String taskId) {
        if(taskKey == null){
            this.taskKey = new TaskKey();
        }
        this.taskKey.setTaskId(taskId);
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }
}
