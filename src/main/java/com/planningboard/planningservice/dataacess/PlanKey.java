package com.planningboard.planningservice.dataacess;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import java.io.Serializable;

public class PlanKey implements Serializable {

    String workspaceId;
    String name ;

    public PlanKey() {
    }

    @DynamoDBHashKey(attributeName = "WorkspaceId")
    public String getWorkspaceId() {
        return workspaceId;
    }



    @DynamoDBRangeKey(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

}
