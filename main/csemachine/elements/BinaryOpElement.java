package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;

public class BinaryOpElement extends ControlElement {

    public BinaryOpElement(String type){
        super(type, true);
    }

    @Override
    public void doWhenPopped(Stack<ControlElement> control, Stack<ControlElement> stack, 
                            Environment env, int envIndex)
    {
        ControlElement rand1 = stack.pop();
        ControlElement rand2 = stack.pop();
        
        switch (type){

            case "+":
                int result = rand1.getInteger() + rand2.getInteger();
                stack.push(new ControlElement(result));
                return;

            default:
                return;

        }
    }

}