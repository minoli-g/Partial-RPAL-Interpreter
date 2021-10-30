package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class GammaElement extends ControlElement {

    public GammaElement(){
        super("gamma", true);
    }

    @Override
    public void doWhenPopped(Stack<ControlElement> control, Stack<ControlElement> stack, 
                            Environment env, int envIndex)
    {
        
    }
}