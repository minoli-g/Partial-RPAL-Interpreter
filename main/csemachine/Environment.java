package main.csemachine;

import main.nodes.*;

public class Environment{

    private String name;
    private HashMap<String,Object> map= new HashMap<String,Object>();

    public Environment(){ }

    public Object lookUp(String identifier) {
        return map.get(identifier);
    }

    public void put(String identifier, Object value){
        map.put(identifier,value);
        return;
    }
}