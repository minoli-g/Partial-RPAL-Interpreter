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

            case "gr":
                if (rand1.getInteger() > rand2.getInteger()) {
                    stack.push(new ControlElement(true));
                }
                else {
                    stack.push(new ControlElement(false));
                }
                return;

            case "ge":
                if (rand1.getInteger() >= rand2.getInteger()) {
                    stack.push(new ControlElement(true));
                }
                else {
                    stack.push(new ControlElement(false));
                }
                return;

            case "ls":
                if (rand1.getInteger() < rand2.getInteger()) {
                    stack.push(new ControlElement(true));
                }
                else {
                    stack.push(new ControlElement(false));
                }
                return;

            case "le":
                if (rand1.getInteger() <= rand2.getInteger()) {
                    stack.push(new ControlElement(true));
                }
                else {
                    stack.push(new ControlElement(false));
                }
                return;

            case "eq":
                if (rand1.getInteger() == rand2.getInteger()) {
                    stack.push(new ControlElement(true));
                }
                else {
                    stack.push(new ControlElement(false));
                }
                return;

            case "ne":
                if (rand1.getInteger() != rand2.getInteger()) {
                    stack.push(new ControlElement(true));
                }
                else {
                    stack.push(new ControlElement(false));
                }
                return;


            case "or":
                stack.push(new ControlElement(rand1.getBool() || rand2.getBool()));
                return;

            case "&":
                stack.push(new ControlElement(rand1.getBool() && rand2.getBool()));
                return;


            default:
                return;

        }
    }

}