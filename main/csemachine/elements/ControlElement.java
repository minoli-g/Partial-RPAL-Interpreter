package main.csemachine.elements;

import main.csemachine.*;
import main.nodes.Node;

import java.util.Stack;
import java.util.ArrayList;

public class ControlElement {

    protected String type;        //gamma, lambda, ->, etc

    protected String strValue; 
    private int intValue;
    private boolean boolValue;
    private ArrayList<ControlElement> tuple;

    public ControlElement(Node n){

        /* 
        if it's something with <>, assign correct type - identifer/string/int/boolean
        anything else: store the string - will be used by subclasses to store subclass type
        */

        String type = n.getType();

        if (type.length()>=4) {

            switch (type.substring(0,4)){

                case "<ID:":
                    this.type = "ID"; this.strValue = type.substring(4,type.length()-1);
                    return;

                case "<INT":
                    this.type = "INT"; this.intValue = Integer.parseInt(type.substring(5,type.length()-1));
                    return;

                case "<STR":
                    this.type = "STR"; this.strValue = type.substring(5,type.length()-1);
                    return;

                default:
                    break;
            }
        }
        
        if (type.equals("<true>")){ this.type = "BOOL"; this.boolValue = true; }
        else if (type.equals("<false>")) { this.type = "BOOL"; this.boolValue = false; }

        else {
            this.type = type;
        }
        return;

    }

    public ControlElement(String s, boolean isType){
        if (isType) {
            this.type = s;
            return;
        }
        type = "STR";
        this.strValue = s;
        return;
    }

    public ControlElement(String s, String type){
        this.type = type;
        this.strValue = s;
        return;
    }

    public ControlElement(int i) {
        type = "INT";
        intValue = i;
        return;
    }

    public ControlElement(boolean b){
        type = "BOOL";
        boolValue = b;
        return;
    }

    public ControlElement() {
        type = "DUMMY";
        return;
    }

    public ControlElement(ArrayList<ControlElement> tuple){
        type = "TUPLE";
        this.tuple = tuple;
        return;
    }

    //what about functions? decide later.


    public String getIdName(){ return strValue; }
    public String getString(){ return strValue; }
    public int getInteger(){ return intValue; }
    public boolean getBool(){ return boolValue; }

    public void doWhenPopped(Stack<ControlElement> control, Stack<ControlElement> stack, 
                            Environment env, int envIndex)
    {

        stack.push(this);  //Default behaviour - Done for names, int/str/bools, and Ystar
        return;

    }

    public String getType(){
        switch (type){
            case "INT":
                return ("INT: "+Integer.toString(intValue));

            case "STR":
                return (type+": "+strValue);

            case "ID":
                return (type + ": " + strValue);

            default:
                return type;
        }
    }

}