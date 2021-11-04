package main.csemachine.elements;

import main.nodes.Node;

public class ControlElementFactory {

    public static ControlElement createElement(Node n) throws Exception{

        String type = n.getType();
        int l = type.length();

        /*  Handling cases of elements which 
            do not need special handling when popped off of control,
            but are not simple values such as Integer and String */

        if (type.equals("gamma")){ return new GammaElement(); }

        if (type.equals("Y")) { return new ControlElement("Y", true); }
        if (type.equals("<nil>")) { return new ControlElement("<nil>", true); }

        if (type.equals("<true>")) { return new ControlElement(true); }
        if (type.equals("<false>")) { return new ControlElement(false); }

        /* Handling elements of a specific RPAL type */ 

        if (l>5){

            if (type.substring(0,4).equals("<ID:")) { return new IdentifierElement(type.substring(4,l-1)); }

            if (type.substring(0,5).equals("<INT:")) { return new ControlElement(Integer.parseInt(type.substring(5,l-1))); }

            if (type.substring(0,5).equals("<STR:")) { return new ControlElement(type.substring(6,l-2), false); }

        }

        /* Handling unary or binary operators */

        if (isUnaryOp(type)) { return new UnaryOpElement(type); }

        if (isBinaryOp(type)) { return new BinaryOpElement(type); }

        else { throw new Exception("Incompatible type " + type); }
    }



    public static boolean isBinaryOp(String operator){

       String[] binops = {"+", "-", "*", "/", "**", "or", "&", "gr", "ge", "ls", "le", "eq", "ne", "aug"};
       for (String s: binops){
           if (operator.equals(s)) { return true; }
       }
       return false;

   }

   public static boolean isUnaryOp(String operator){

       String unops[] = {"neg", "not"};
       for (String s: unops){
           if (operator.equals(s)) { return true; }
       }
       return false;

   }
}