package com.planningboard.planningservice.dataacess.repository;

import com.planningboard.planningservice.dataacess.Plan;
import com.planningboard.planningservice.dataacess.Task;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@EnableScan
public interface TaskRepository extends CrudRepository<Task, String> {
    List<Task> findByPlanId(String planId);
}

