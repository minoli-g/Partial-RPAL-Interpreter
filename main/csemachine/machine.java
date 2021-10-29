package main.csemachine;

import java.util.ArrayList;
import java.util.Stack;

import main.nodes.*;

public class Machine {

    private ControlStructureGroup csg;

    private Stack<ControlElement> control;
    private Stack<ControlElement> stack;

    public Machine(Node rootOfTree){ 

        csg = new ControlStructureGroup();
        csg.createControlStructure(rootOfTree);

        control = new Stack<ControlElement>();
        stack = new Stack<ControlElement>();
    }

    // When you initialize the machine, it has the control structures and empty Control & Stack ready to go

    public String evaluate(){

        //Add first COntrol Structure to Control
        addToControl(csg.getControlStructureAt(0),0);

        //While COntrol is not empty, pop the last element and follow the rules to edit control and stack 

        //return the last element on stack as a String 
        return "";
    }

    public void addToControl(ControlStructure cs, int index){
        control.push(new ExpElement(index));
        for (ControlElement ce: cs.getControlElements()){
            control.push(ce);
        }
    }
   











    public static void traverse(Node n){
        ArrayList<String> al = new ArrayList<String>();
        al = n.traverse(al);

        for (String s: al) {
            System.out.println(s);
        }
    }

    public static void evaluate(ArrayList<String> control){

        Stack stack = new Stack();

        while (control.size() > 0){

            String last = control.get(control.size()-1);

            //depending on the type of last, do something w the stack.
            /*
            if (identifier) {
                stack.push(environment.lookup(identifer))
            }
            if (unop) {

            }
            if (binop) {

            }
            if (tau) {

            }
            ...
            */
        }
    }

}