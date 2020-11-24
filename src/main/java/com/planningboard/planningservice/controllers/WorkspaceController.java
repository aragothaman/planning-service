package com.planningboard.planningservice.controllers;

import com.planningboard.planningservice.dataacess.Plan;
import com.planningboard.planningservice.dataacess.Workspace;
import com.planningboard.planningservice.dataacess.repository.WorkspaceRepository;
import com.planningboard.utilities.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WorkspaceController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    WorkspaceRepository repository ;

    @GetMapping("/workspaces/{name}")
    public Workspace getWorkspace(@PathVariable String name) {
        return this.repository.findByName(name);
    }

    @GetMapping("/workspaces")
    public Iterable<Workspace> findAll() {
        return this.repository.findAll();
    }

    @PostMapping(value="/workspaces", produces="application/json", consumes = "application/json")
    public Workspace createWorkspace(@RequestBody Workspace workspace){
        String sid2 = IdGenerator.getInstance().getShortId();
        workspace.setWorkspaceId(sid2);
        return this.repository.save(workspace);
    }

}