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


    public ControlElement(String s, boolean isType){
        if (isType) {
            this.type = s;
            return;
        }
        type = "STR";
        this.strValue = s; //Removing the quotes
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
    public ArrayList<ControlElement> getTuple() { return tuple; }

    public void doWhenPopped(Machine machine)
    {

        machine.getStack().push(this);  //Default behaviour - Done for names, int/str/bools, and Ystar
        return;

    }

    public String getType(){ return type; }

    public String returnBaseValue(){
        switch (type) {
            case "STR": return strValue;
            case "INT": return Integer.toString(intValue);
            case "BOOL": return Boolean.toString(boolValue);
            case "DUMMY": return "dummy";
            case "TUPLE": 
                ArrayList<String> list = new ArrayList<String>();
                for (ControlElement ce: this.tuple) { list.add(ce.returnBaseValue()); }
                return ( "(" + String.join(", ",list) + ")" );
        }
        return "Error - returnBaseValue can't handle this";
    }

    public void print(){
        System.out.println(returnBaseValue());
    }


}