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

    public ArrayList<String> getBindings(){
        return bindings;
    }

    @Override
    public void doWhenPopped(Stack<ControlElement> control, Stack<ControlElement> stack, 
                            Environment env, int envIndex)
    {
        this.setEnvironment(envIndex);
        stack.push(this);
    }
}