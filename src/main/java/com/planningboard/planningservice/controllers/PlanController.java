package com.planningboard.planningservice.controllers;

import com.planningboard.planningservice.dataacess.Plan;
import com.planningboard.planningservice.dataacess.Workspace;
import com.planningboard.planningservice.dataacess.repository.PlanRepository;
import com.planningboard.planningservice.dataacess.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlanController {
    @Autowired
    PlanRepository repository ;

    @GetMapping("/workspaces/{workspaceId}/plans")
    public List<Plan> getWorkspace(@PathVariable String workspaceId, @RequestParam(required = false) String name) {

        if( name != null){
            List<Plan> plans = this.repository.findByWorkspaceIdAndName(workspaceId, name);
            return plans ;
        }
        return this.repository.findByWorkspaceId(workspaceId);
    }
}