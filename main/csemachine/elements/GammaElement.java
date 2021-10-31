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
            Environment newEnv = new Environment(currentEnvironment);

            ArrayList<String> bindings = le.getBindings();

            if (bindings.size()==1) { 
            //for single binding

                String identifier = le.getBindings().get(0);
                newEnv.put(identifier,rand);
            }
            else {
                ArrayList<ControlElement> tuple = rand.getTuple();

                for (int i=0; i<bindings.size(); i++) {
                    newEnv.put(bindings.get(i),tuple.get(i));
                }
            }

            Environment oldEnv = machine.getEnvironment();
            newEnv.setParent(oldEnv);
            machine.setEnvironment(newEnv);

            return;
        }

        if (stackTop.getType().equals("TUPLE")){

            int i = stack.pop().getInteger();
            ControlElement ce = stackTop.getTuple().get(i-1);  //Indexing in RPAL starts at 1

            stack.push(ce);
        }

        if (stackTop instanceof IdentifierElement){

            IdentifierElement ie = (IdentifierElement) stackTop;
            ControlElement ce = stack.pop();

            switch (ie.getIdName()){
                case "Print":
                    ce.print();
                    stack.push(new ControlElement()); //dummy
                    return;

                case "Isdummy":
                    if (ce.getType().equals("DUMMY")){
                        stack.push(new ControlElement(true));
                        return;
                    }
                    else{
                        stack.push(new ControlElement(false));
                        return;
                    }

                case "Isinteger":
                    if (ce.getType().equals("INT")){
                        stack.push(new ControlElement(true));
                        return;
                    }
                    else{
                        stack.push(new ControlElement(false));
                        return;
                    }

                case "Istruthvalue":
                    if (ce.getType().equals("BOOL")){
                        stack.push(new ControlElement(true));
                        return;
                    }
                    else{
                        stack.push(new ControlElement(false));
                        return;
                    }

                case "Isstring":
                    if (ce.getType().equals("STR")){
                        stack.push(new ControlElement(true));
                        return;
                    }
                    else{
                        stack.push(new ControlElement(false));
                        return;
                    }

                //should do isfunction and istuple

                default:
                    return;
            }
        }
        
    }
}