package com.planningboard.planningservice.dataacess;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.io.Serializable;

public class WorkspaceKey implements Serializable {
    String name ;
    String workspaceId;

    public WorkspaceKey() {
    }

    @DynamoDBHashKey(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @DynamoDBRangeKey(attributeName = "WorkspaceId")
    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

    @Override
    public String toString() {
        return "WorkspaceKey{" +
                "name='" + name + '\'' +
                ", workspaceId='" + workspaceId + '\'' +
                '}';
    }
}
