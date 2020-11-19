package com.planningboard.planningservice.dataobject ;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

@DynamoDBTable(tableName = "Workspaces")
public class Workspace {



    @Id
    WorkspaceKey workspaceKey;

    public Workspace(){

    }

    public void setName(String name) {
        if(workspaceKey == null) {
            this.workspaceKey = new WorkspaceKey();
        }
        workspaceKey.setName(name);
    }

    @DynamoDBRangeKey(attributeName = "WorkspaceId")
    public String getWorkspaceId() {
        return workspaceKey.getWorkspaceId();
    }

    public void setWorkspaceId(String id) {
        if(workspaceKey == null) {
            this.workspaceKey = new WorkspaceKey();
        }
        workspaceKey.setWorkspaceId(id);
    }

    @DynamoDBHashKey(attributeName = "Name")
    public String getName() {
        return workspaceKey.getName();
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "workspaceKey=" + workspaceKey +
                '}';
    }
}
