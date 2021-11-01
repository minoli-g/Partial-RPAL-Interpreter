package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class LambdaElement extends ControlElement {

    private ArrayList<String> bindings;
    private int index;
    private Environment env; 

    public LambdaElement(ArrayList<String> bindings, int index){
        super("lambda", true);
        this.bindings = bindings; this.index = index;
    }

    public void setEnvironment(Environment env){
        this.env = env;
    }

    public int getIndex() { return index; }
    public ArrayList<String> getBindings() {    return bindings;    }
    public Environment getEnvironment() {   return env;     }

    @Override
    public void doWhenPopped(Machine machine)
    {
        this.setEnvironment(machine.getEnvironment());
        machine.getStack().push(this);
    }
}