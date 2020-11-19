package com.planningboard.planningservice.dataobject;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface WorkspaceRepository extends CrudRepository<Workspace, String> {
    List<Workspace> findByName(String name);
}