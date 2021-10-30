package main.csemachine;

import java.util.ArrayList;

public class LambdaElement extends ControlElement {

    private ArrayList<String> bindings;
    private int index;
    private int environment; //this will be used on the stack only

    public LambdaElement(ArrayList<String> bindings, int index){
        super("lambda");
        this.bindings = bindings; this.index = index;
    }

    public void setEnvironment(int environment){
        this.environment = environment;
    }

    public ArrayList<String> getBindings(){
        return bindings;
    }
}