package com.planningboard.planningservice.controllers;

import com.planningboard.planningservice.dataacess.Task;
import com.planningboard.planningservice.dataacess.repository.TaskRepository;
import com.planningboard.utilities.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskRepository repository ;

    @GetMapping("/plans/{planId}/tasks")
    public List<Task> findTasks(@PathVariable String planId){
        return this.repository.findByPlanId(planId);
    }

    @PostMapping(value="/plans/{planId}/tasks", produces="application/json", consumes = "application/json")
    public Task createPlan(@PathVariable String planId, @RequestBody Task task){
        String sid2 = IdGenerator.getInstance().getShortId();
        task.setTaskId(sid2);
        return this.repository.save(task);
    }
}
