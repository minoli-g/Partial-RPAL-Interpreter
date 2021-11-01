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

        csg = new ControlStructureGroup();
        csg.createControlStructure(rootOfTree);

        control = new Stack<ControlElement>();
        stack = new Stack<ControlElement>();

        currentEnvironment = new Environment(0);
        lastEnvIndex = 0;
    }

    public ControlElement evaluate() throws Exception {
        //Starts with an empty control

        ExpElement env = new ExpElement(currentEnvironment); //principal env
        control.push(env);

        for (ControlElement ce: csg.getControlStructureAt(0).getControlElements()){
            control.push(ce);
        }
        stack.push(env);

        //Control - e0 delta0, Stack - e0

        while (control.size()>0) {

            displayControl();
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

        for (ControlElement ce: csg.getControlStructureAt(index).getControlElements()){
            control.push(ce);
        }
    }

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

    // When you initialize the machine, it has the control structures and empty Control & Stack ready to go
/*
    public String evaluate() throws Exception{

        //Add first COntrol Structure to Control
        addToControl(csg.getControlStructureAt(0),0);

        //While COntrol is not empty, pop the last element and follow the rules to edit control and stack 
        while (control.size()>0){

            ControlElement ce = control.pop();

            switch (ce.getType()){
                
                //Rule 1: A name
                case "ID":
                    Object ob = currentEnvironment.lookUp(ce.getIdName());
                    stack.push(ob);
                    break;

                case "Y":
                    stack.push("Y");
                    break;

                //Rule 2: Lambda
                case "lambda":
                    LambdaElement le = (LambdaElement) ce;
                    le.setEnvironment(currentEnvironment.getIndex());
                    stack.push(ce);
                    break;

                //Rule 3: Apply rator - Redundant because of Rules 6 and 7
                //Rule 4 and 11: Apply lambda
                //Rule 10: Tuple selection
                //Rule 12: Y and lambda
                //Rule 13: Eta
                case "gamma":
                    Object newOb = stack.pop();

                    if (newOb instanceof LambdaElement) {

                        Object rand = stack.pop();
                        //set the new environment with the bindings

                    }
                    else if (newOb instanceof ArrayList){
            
                        int index = (Integer) stack.pop();
                        ArrayList<Object> al = (ArrayList<Object>) newOb;

                        stack.push(al.get(index));
                    }
                    else { throw new Exception("gamma and incompatible type "+ce.toString()); }

                    break;

                //Rule 5: Exit environment
                case "e":
                    Object value = stack.pop();
                    Object e = stack.pop();
                    stack.push(value);
                    break;

                //Rule 6 & 7 handled in default section

                //Rule 8: Conditional handling with beta
                case "beta":
                    Object bool = stack.pop();
                    if (bool instanceof Boolean){
                        Boolean then = (Boolean) bool;

                        if (then) { 
                            control.pop(); 
                            ControlElement deltaThen = control.pop(); 
                            control.push(deltaThen); //replace with code to put the relevant control strucutre
                        }
                        else { 
                            ControlElement deltaElse = control.pop(); 
                            control.pop(); 
                            control.push(deltaElse); 
                        }
                    }
                    else { throw new Exception("beta not followed by boolean on stack"); }
                    break;

                //Rule 9: Tuple formation
                case "tau":

                    TauElement te = (TauElement) ce;
                    int numOfElements = te.getNumberOfElements();

                    ArrayList<Object> tuple = new ArrayList<Object>();

                    for (int i=0; i<numOfElements; i++){
                        tuple.add(stack.pop());
                    }
                    stack.push(tuple);
                    break;

                
                default:
                    if (isBinaryOp(ce.getType())){
                        
                        break;
                    }
                    else if (isUnaryOp(ce.getType())){

                        break;
                    }
                    else {
                        throw new Exception("Invalid element on control");
                    }
            }
        }

        //return the last element on stack as a String 
        return "";
    }

    public void addToControl(ControlStructure cs, int index){
        control.push(new ExpElement(index));
        for (ControlElement ce: cs.getControlElements()){
            control.push(ce);
        }
    }
   
   public boolean isBinaryOp(String operator){

       String[] binops = {"+", "-", "*", "/", "**", "or", "&", "gr", "ge", "ls", "le", "eq", "ne"};
       for (String s: binops){
           if operator.equals(s) { return true; }
       }
       return false;

   }

   public boolean isUnaryOp(String operator){

       String unops[] = {"neg", "not"};
       for (String s: unops){
           if operator.equals(s) { return true; }
       }
       return false;

   }

}
*/