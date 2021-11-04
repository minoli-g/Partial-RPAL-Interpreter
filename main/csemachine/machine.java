package main.csemachine;

import main.csemachine.elements.*;

import java.util.ArrayList;
import java.util.Stack;

import main.nodes.*;

public class Machine {

    private ControlStructureGroup csg;

    private Stack<ControlElement> control;
    private Stack<ControlElement> stack;

    private Environment currentEnvironment;
    private int lastEnvIndex;

    public Machine(Node rootOfTree) throws Exception { 
        /* Initializes the Machine and adds all control structures generated 
        from the root of the standardized tree */

        csg = new ControlStructureGroup();
        csg.createControlStructure(rootOfTree);

        control = new Stack<ControlElement>();
        stack = new Stack<ControlElement>();

        currentEnvironment = new Environment(0);
        lastEnvIndex = 0;
    }

    public ControlElement evaluate() throws Exception {
        /* Evaluates the program consisting of the control structures */
        
        
        //Starts with an empty control

        ExpElement env = new ExpElement(currentEnvironment); //principal env
        control.push(env);

        for (ControlElement ce: csg.getControlStructureAt(0).getControlElements()){
            control.push(ce);
        }
        stack.push(env);

        //Control - e0 delta0, Stack - e0

        while (control.size()>0) {

            //displayControl();   - this is used to debug

            ControlElement ce = control.pop();
            ce.doWhenPopped(this);

        }
        return stack.pop();
    }

    public Stack<ControlElement> getControl() { return control; }
    public Stack<ControlElement> getStack() {   return stack;   }
    public Environment getEnvironment() { return currentEnvironment; }
    public int getLastEnvIndex() { return lastEnvIndex; }

    public void setEnvironment(Environment env) { currentEnvironment = env; }
    public void setLastEnvIndex(int lastEnvIndex){ this.lastEnvIndex = lastEnvIndex;    }


    public void addStructureToControl(int index){

        /* Adds a Control Structure stored in the Group at a certain location, to the Control */

        for (ControlElement ce: csg.getControlStructureAt(index).getControlElements()){
            control.push(ce);
        }
    }

    /* Debugging purposes only */

    public void displayControl(){

        for (ControlElement ce: control){
            if (ce.getType().equals("bool")){ System.out.println(ce.getBool()); }
            else if (ce.getType().equals("INT")){ System.out.print(ce.getInteger()); }
            else if (ce.getType()!="lambda") { System.out.print(ce.getType()+"  "); }
            else { 
                    LambdaElement le = (LambdaElement) ce;
                    System.out.print("Lambda " +
                    Integer.toString(le.getIndex()) + le.getBindings().toString() + "  "); }
            }

            System.out.println("");
    }

}

