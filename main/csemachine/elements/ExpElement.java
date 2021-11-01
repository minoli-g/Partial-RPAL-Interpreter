package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ListIterator;

public class ExpElement extends ControlElement {

    private Environment env;

    public ExpElement(Environment env){
        super("e",true);
        this.env = env;
    }

    public Environment getEnvironment(){    return env;     }

    @Override
    public void doWhenPopped(Machine machine) {

        Stack<ControlElement> stack = machine.getStack();
        Environment currentEnvironment = machine.getEnvironment();

        ControlElement topValue = stack.pop();   //Element before the Exp on stack
        stack.pop();                             //Exp element


        //Must find next env on stack
        ListIterator<ControlElement> si = stack.listIterator(stack.size());

        while (si.hasPrevious()) {
            
            ControlElement ce = si.previous();

            if (ce instanceof ExpElement){
                
                ExpElement ee = (ExpElement) ce;
                Environment newEnv = ee.getEnvironment();

                machine.setEnvironment(newEnv);  //new env set for mchine
                break;
            }
        }



        stack.push(topValue);
        return;
    }
    
    
}