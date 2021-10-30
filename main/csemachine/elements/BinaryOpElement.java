package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;

public class BinaryOpElement extends ControlElement {

    public BinaryOpElement(String type){
        super(type, true);
    }

    @Override
    public void doWhenPopped(Machine machine){

        Stack<ControlElement> stack = machine.getStack();

        ControlElement rand1 = stack.pop();
        ControlElement rand2 = stack.pop();
        
        switch (type){

            case "+":
                stack.push(new ControlElement(
                    rand1.getInteger() + rand2.getInteger()
                ));
                return;

            case "-":
                stack.push(new ControlElement(
                    rand1.getInteger() - rand2.getInteger()
                ));
                return;

            case "*":
                stack.push(new ControlElement(
                    rand1.getInteger() * rand2.getInteger()
                ));
                return;

            case "/":
                stack.push(new ControlElement(
                    rand1.getInteger() / rand2.getInteger()
                ));
                return;

            case "**":
                stack.push(new ControlElement(
                    (int) Math.pow(rand1.getInteger(),rand2.getInteger())
                ));
                return;

            default:
                return;

        }
    }

}