package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class GammaElement extends ControlElement {

    public GammaElement(){
        super("gamma", true);
    }

    @Override
    public void doWhenPopped(Machine machine)
    {

        Stack<ControlElement> stack = machine.getStack();
        

        ControlElement stackTop = stack.pop();

        if (stackTop instanceof LambdaElement) {

            LambdaElement le = (LambdaElement) stackTop;
            ControlElement rand = stack.pop();

            int currentEnvironment = machine.getEnvironment().getIndex();
            currentEnvironment++;

            ExpElement en = new ExpElement(currentEnvironment);
            machine.getControl().push(en);
            machine.getStack().push(en);

            machine.addStructureToControl(le.getIndex());

            //Create new environment binding lambda's bindings to rand
            //Temporary - for single binding

            String identifier = le.getBindings().get(0);
            Environment newEnv = new Environment(currentEnvironment);
            newEnv.put(identifier,rand);

            Environment oldEnv = machine.getEnvironment();
            newEnv.setParent(oldEnv);
            machine.setEnvironment(newEnv);

            return;
        }

        if (stackTop instanceof IdentifierElement){

            IdentifierElement ie = (IdentifierElement) stackTop;
            ControlElement ce = machine.getStack().pop();

            switch (ie.getIdName()){
                case "Print":
                    ce.print();
                    machine.getStack().push(new ControlElement()); //dummy
                    return;

                default:
                    return;
            }
        }
        
    }
}