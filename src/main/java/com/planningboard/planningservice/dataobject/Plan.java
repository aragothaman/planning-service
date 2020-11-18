package com.planningboard.planningservice.dataobject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plan {
    String name ;
    Map<Long, Task> tasks = new HashMap<Long, Task>();

    public Plan(String name) {
        this.name = name;
    }

    public void addTask(Long id, Task task){
        tasks.put(id, task);
    }
}
