package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class IdentifierElement extends ControlElement {

    public IdentifierElement(String s){
        super(s, "ID");
    }

    @Override
    public void doWhenPopped(Machine machine){

        Stack<ControlElement> stack = machine.getStack();
        Environment env = machine.getEnvironment();

        //if reserved, just push. Gamma will handle it. Else, look it up in env and push.
        
        if (isReserved(this.strValue)){
            stack.push(this);
            return;
        }
        stack.push(env.lookUp(this.strValue)); //it will be a ControlElement and not IDentiferElement
        
    }

    public static boolean isReserved(String identifier){

        String[] reservedIdentifiers = {"Print", "Isdummy", "Isinteger", "Istruthvalue",
                                        "Isstring", "Isfunction", "Istuple", "Order", "Null",
                                        "Stem", "Stern", "Conc"};

        for (String s: reservedIdentifiers) {
            if (identifier.equals(s)){
                return true;
            }
        }
        return false;
    }
}