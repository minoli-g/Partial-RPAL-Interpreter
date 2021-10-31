package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class BetaElement extends ControlElement {

    public BetaElement(){
        super("beta", true);
    }

    @Override
    public void doWhenPopped(Machine machine)
    {
        Stack<ControlElement> stack = machine.getStack();
        Stack<ControlElement> control = machine.getControl();

        boolean boolValue = stack.pop().getBool();

        DeltaElement deltaElse = (DeltaElement) control.pop();
        DeltaElement deltaThen = (DeltaElement) control.pop();

        int nextIndex;

        if (boolValue) { nextIndex = deltaThen.getIndex(); }
        else { nextIndex = deltaElse.getIndex(); }

        machine.addStructureToControl(nextIndex);

        return;
    }

}