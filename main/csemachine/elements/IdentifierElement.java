package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class IdentifierElement extends ControlElement {

    public IdentifierElement(String s){
        super(s, "ID");
    }

    @Override
    public void doWhenPopped(Stack<ControlElement> control, Stack<ControlElement> stack, 
                            Environment env, int envIndex)
    {

        //if reserved, just push and let gamma handle it. Else, look it up in env and push.
        
    }
}