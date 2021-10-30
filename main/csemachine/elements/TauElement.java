package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;

public class TauElement extends ControlElement {

    private int number;

    private ArrayList<ControlElement> tuple; 

    public TauElement(int number) { 
        super("tau",true);
        this.number = number; 
        tuple = new ArrayList<ControlElement>();
    }

    @Override
    public void doWhenPopped(Stack<ControlElement> control, Stack<ControlElement> stack, 
                            Environment env, int envIndex)
    {
        //Create a tuple out of last few elements on stack and push 

        for (int i=0; i<number; i++){   tuple.add(stack.pop());  }

        stack.push(this);
    }
}