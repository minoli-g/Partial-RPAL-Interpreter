package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class UnaryOpElement extends ControlElement {

    public UnaryOpElement(String type){
        super(type,true);
    }

    @Override
    public void doWhenPopped(Machine machine){

        Stack<ControlElement> stack = machine.getStack();

        ControlElement rand = stack.pop();

        switch (type){

            case "not":
                if (!rand.getBool()) {  stack.push(new ControlElement(true));   }
                else {  stack.push(new ControlElement(false));   }
                return;

            case "neg":
                stack.push(new ControlElement(-1* rand.getInteger()));
                return;

            default:
                return;

        }
    }
}