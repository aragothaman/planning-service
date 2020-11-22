package com.planningboard.planningservice.dataacess;

import java.util.HashMap;
import java.util.Map;

public class DataStore {
    public static DataStore myInstance = new DataStore();

    Map<String, Workspace> workspaceMap = new HashMap<String, Workspace>();

    public Workspace getWorkspace(String name){
        return this.workspaceMap.get(name);
    }

    public void addWorkspace(String name, Workspace wspace){
        this.workspaceMap.put(name, wspace);
    }

    public static DataStore getStore(){
        return DataStore.myInstance ;
    }

    public static DataStore getTestStore(){
        DataStore store = new DataStore();
//        store.addWorkspace("100", new Workspace("MY WORKSPACE"));
        return store ;
    }
}
