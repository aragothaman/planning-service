package com.planningboard.planningservice.dataacess;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

import java.util.List;

@DynamoDBTable(tableName = "Workspaces")
public class Workspace {

    @Id
    WorkspaceKey workspaceKey;

    List<String> teams ;

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


    public List<String> getTeams(){
        return this.teams ;
    }

    public void setTeams(List<String> teams){
        this.teams = teams ;
    }


    @Override
    public String toString() {
        return "Workspace{" +
                "workspaceKey=" + workspaceKey +
                '}';
    }
}
