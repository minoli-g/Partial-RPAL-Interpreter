package main.csemachine;

import main.csemachine.elements.*;
import main.nodes.*;

import java.util.HashMap;

public class Environment{

    private int index;
    private HashMap<String,ControlElement> map;
    private Environment parent;

    public Environment(){ 
        map = new HashMap<String,ControlElement>();
    }

    public Environment(int index){
        this.index = index;
        map = new HashMap<String,ControlElement>();
    }

    public int getIndex() { return index; }
    public Environment getParent() { return parent; }

    public void setParent(Environment parent) {
        this.parent = parent;
    }

    public ControlElement lookUp(String identifier) {

        if (map.containsKey(identifier)){
            return map.get(identifier);
        }
        else if (parent != null) {
            return parent.lookUp(identifier);
        }
        return new ControlElement();
        //throw new Exception("lookup failed");
        
    }

    public void put(String identifier, ControlElement value){
        map.put(identifier,value);
        return;
    }
}