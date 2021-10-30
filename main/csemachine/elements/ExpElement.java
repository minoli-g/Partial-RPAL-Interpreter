package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;

public class ExpElement extends ControlElement {

    private int index;

    public ExpElement(int index){
        super("e",true);
        this.index = index;
    }

    @Override
    public void doWhenPopped(Machine machine) {

        Stack<ControlElement> stack = machine.getStack();

        ControlElement ce = stack.pop();
        stack.pop();
        stack.push(ce);
        return;
    }
    
    
}