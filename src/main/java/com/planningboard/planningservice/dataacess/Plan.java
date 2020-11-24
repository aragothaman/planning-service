package com.planningboard.planningservice.dataacess;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.data.annotation.Id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DynamoDBTable(tableName = "Plans")
public class Plan {

    @Id
    PlanKey planKey ;
    String planId ;
    List<String> teams ;

    @DynamoDBHashKey(attributeName = "workspace_id")
    public String getWorkspaceId() {
        return planKey.getWorkspaceId();
    }

    public void setWorkspaceId(String workspaceId) {
        if(planKey == null){
            this.planKey = new PlanKey();
        }
        this.planKey.setWorkspaceId(workspaceId);
    }

    @DynamoDBRangeKey(attributeName = "plan_name")
    public String getName() {
        return this.planKey.getName();
    }

    public void setName(String name) {
        if(planKey == null){
            this.planKey = new PlanKey();
        }
        this.planKey.setName(name);
    }

    @DynamoDBAttribute(attributeName = "plan_id")
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public List<String> getTeams(){
        return this.teams ;
    }

    public void setTeams(List<String> teams){
        this.teams = teams ;
    }
}
