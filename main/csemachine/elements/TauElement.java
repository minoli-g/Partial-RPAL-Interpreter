package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;

public class TauElement extends ControlElement {

    private int number;

    public TauElement(int number) { 
        super("tau",true);
        this.number = number; 
    }

    @Override
    public void doWhenPopped(Machine machine)
    {
        //Create a tuple out of last few elements on stack and push 
        ArrayList<ControlElement> tuple = new ArrayList<ControlElement>();
        Stack<ControlElement> stack = machine.getStack();

        for (int i=0; i<number; i++){   tuple.add(stack.pop());  }

        stack.push(new ControlElement(tuple));
    }
}