package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class LambdaElement extends ControlElement {

    private ArrayList<String> bindings;
    private int index;
    private int environment; //this will be used on the stack only

    public LambdaElement(ArrayList<String> bindings, int index){
        super("lambda", true);
        this.bindings = bindings; this.index = index;
    }

    public void setEnvironment(int environment){
        this.environment = environment;
    }

    public int getIndex() { return index; }
    public ArrayList<String> getBindings() {    return bindings;    }
    public int getEnvironment() {   return environment;     }

    @Override
    public void doWhenPopped(Machine machine)
    {
        this.setEnvironment(machine.getEnvironment().getIndex());
        machine.getStack().push(this);
    }
}