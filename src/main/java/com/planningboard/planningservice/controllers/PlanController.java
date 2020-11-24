package com.planningboard.planningservice.controllers;

import com.planningboard.planningservice.dataacess.Plan;
import com.planningboard.planningservice.dataacess.Workspace;
import com.planningboard.planningservice.dataacess.repository.PlanRepository;
import com.planningboard.planningservice.dataacess.repository.WorkspaceRepository;
import com.planningboard.utilities.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanController {
    @Autowired
    PlanRepository repository;

    @GetMapping("/workspaces/{workspaceId}/plans")
    public List<Plan> getPlan(@PathVariable String workspaceId, @RequestParam(required = false) String name) {

        if (name != null) {
            List<Plan> plans = this.repository.findByWorkspaceIdAndName(workspaceId, name);
            return plans;
        }
        return this.repository.findByWorkspaceId(workspaceId);
    }

    @GetMapping("/plans/{planId}")
    public List<Plan> getPlanById(@PathVariable String planId) {
        List<Plan> plans = this.repository.findByPlanId(planId);
        return plans;
    }

    @PostMapping(value="/workspaces/{workspaceId}/plans", produces="application/json", consumes = "application/json")
    public Plan createPlan(@PathVariable String workspaceId, @RequestBody Plan plan){
        String sid2 = IdGenerator.getInstance().getShortId();
        plan.setPlanId(sid2);
        return this.repository.save(plan);
    }
}