package com.planningboard.planningservice.dataobject ;

import java.util.HashMap;
import java.util.Map;

public class Workspace {
    String name ;
    Map<Long, Plan> plans = new HashMap<Long, Plan>();

    public String getName() {
        return name;
    }

    public Workspace(String name) {
        this.name = name;
    }

    public void addPlan(Long id, Plan plan){
        this.plans.put(id, plan);
    }
}
