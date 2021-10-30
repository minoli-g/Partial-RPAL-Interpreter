package main.csemachine;

import main.nodes.*;

import java.util.HashMap;

public class Environment{

    private int index;
    private HashMap<String,Object> map;
    private Environment parent;

    public Environment(){ 
        map = new HashMap<String,Object>();
    }

    public Environment(int index){
        this.index = index;
        map = new HashMap<String,Object>();
    }

    public int getIndex() { return index; }

    public void setParent(Environment parent) {
        this.parent = parent;
    }

    public Object lookUp(String identifier) throws Exception {

        if (map.containsKey(identifier)){
            return map.get(identifier);
        }
        else if (parent != null) {
            return parent.lookUp(identifier);
        }
        
        throw new Exception("lookup failed");
        
    }

    public void put(String identifier, Object value){
        map.put(identifier,value);
        return;
    }
}