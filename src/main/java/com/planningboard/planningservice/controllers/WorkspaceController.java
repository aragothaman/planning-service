package com.planningboard.planningservice.controllers;

import com.planningboard.planningservice.Greeting;
import com.planningboard.planningservice.dataobject.DataStore;
import com.planningboard.planningservice.dataobject.Workspace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class WorkspaceController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/workspaces/{name}")
    public Workspace getWorkspace(@PathVariable String name) {
        DataStore store = DataStore.getTestStore();
        return store.getWorkspace(name);
    }
}