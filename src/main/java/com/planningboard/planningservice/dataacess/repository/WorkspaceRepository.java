package com.planningboard.planningservice.dataacess.repository;

import com.planningboard.planningservice.dataacess.Workspace;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface WorkspaceRepository extends CrudRepository<Workspace, String> {
    Workspace findByName(String name);
}