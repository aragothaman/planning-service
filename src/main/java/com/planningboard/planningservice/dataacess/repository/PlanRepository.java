package com.planningboard.planningservice.dataacess.repository;

import com.planningboard.planningservice.dataacess.Plan;
import com.planningboard.planningservice.dataacess.Workspace;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface PlanRepository extends CrudRepository<Plan, String>  {
    List<Plan> findByWorkspaceId(String workspaceId);
    List<Plan> findByWorkspaceIdAndName(String workspaceId, String name);
}


