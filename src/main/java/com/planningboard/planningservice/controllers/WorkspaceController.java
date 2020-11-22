package com.planningboard.planningservice.controllers;

import com.planningboard.planningservice.dataacess.Workspace;
import com.planningboard.planningservice.dataacess.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}