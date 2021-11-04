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

        /* Gamma Elements, when popped off control, behave differently 
            depending on the element at the top of the stack.
            This function checks the stack top and executes relevant behaviour */

        Stack<ControlElement> stack = machine.getStack();
        ControlElement stackTop = stack.pop();

        if (stackTop instanceof LambdaElement) {

            /* Switch environment and create bindings */

            LambdaElement le = (LambdaElement) stackTop;
            ControlElement rand = stack.pop();

            int newLastEnvIndex = machine.getLastEnvIndex() + 1;

            //Create new environment binding lambda's bindings to rand
            Environment newEnv = new Environment(newLastEnvIndex);

            ExpElement en = new ExpElement(newEnv);

            machine.getControl().push(en);
            stack.push(en);

            machine.addStructureToControl(le.getIndex());


            //Adding the bindings to the env
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

            Environment oldEnv = le.getEnvironment();
            newEnv.setParent(oldEnv);

            machine.setEnvironment(newEnv);
            machine.setLastEnvIndex(newLastEnvIndex);

            return;
        }

        if (stackTop.getType().equals("TUPLE")){

            /* Gamma acts as a Tuple selector */

            int i = stack.pop().getInteger();
            ControlElement ce = stackTop.getTuple().get(i-1);  //Indexing in RPAL starts at 1

            stack.push(ce);
            return;
        }

        if (stackTop.getType().equals("Y")){

            /* Special behaviour for recursion */

            LambdaElement le = (LambdaElement) stack.pop();
            EtaElement ee = new EtaElement(le);

            stack.push(ee);

            return;
        }

        if (stackTop instanceof EtaElement) {

            /* Exit the environment represented in the eta */

            EtaElement ee = (EtaElement) stackTop;

            machine.getControl().push(new GammaElement());
            machine.getControl().push(new GammaElement());
            stack.push(ee);
            stack.push(ee.getLambdaElement());
            return;
        }

        if (stackTop instanceof IdentifierElement){

            /* IdentifierElement, when on the stack, represents a default function of RPAL
                Execute that function on the operand next on stack*/

            IdentifierElement ie = (IdentifierElement) stackTop;
            ControlElement ce = stack.pop();

            switch (ie.getIdName()){
                case "Print":
                    ce.print();
                    stack.push(new ControlElement()); //dummy
                    return;

                case "Order":
                    int order = ce.getTuple().size();
                    stack.push(new ControlElement(order));
                    return;

                case "Null":
                    if (ce.getType().equals("<nil>")){
                        stack.push(new ControlElement(true));
                        return;
                    }
                    else{
                        stack.push(new ControlElement(false));
                        return;
                    }

                case "Stem":
                    stack.push(new ControlElement(ce.getString().substring(0,1),false));
                    return;

                case "Stern":
                    String str = ce.getString();
                    stack.push(new ControlElement(str.substring(1,str.length()),false));
                    return;

                case "Conc":
                    ControlElement ce2 = stack.pop();
                    stack.push(new ControlElement(ce.getString() + ce2.getString(), false));

                    //Remove behind gamma from control
                    machine.getControl().pop();
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

                case "Istuple":
                    if (ce.getType().equals("TUPLE")){
                        stack.push(new ControlElement(true));
                        return;
                    }
                    else{
                        stack.push(new ControlElement(false));
                        return;
                    }

                default:
                    return;
            }
        }
        
    }
}