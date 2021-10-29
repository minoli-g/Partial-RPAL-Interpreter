package main.csemachine;

import java.util.ArrayList;
import java.util.Stack;

import main.nodes.*;

public class machine {

    private ControlStructureGroup csg;

    public machine(){ csg = new ControlStructureGroup(); }

    public void display() {
        csg.display();
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