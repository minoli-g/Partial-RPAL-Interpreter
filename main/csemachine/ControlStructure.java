package main.csemachine;

import main.csemachine.elements.*;

import java.util.Stack;

public class ControlStructure {

    private Stack<ControlElement> controlStructure; 

    public ControlStructure(){
        controlStructure = new Stack<ControlElement>();
    }

    public void addElement(ControlElement ce) {
        controlStructure.push(ce);
    }

    public ControlElement removeLastElement(){
        return controlStructure.pop();
    }

    public Stack<ControlElement> getControlElements(){
        return controlStructure;
    }
}