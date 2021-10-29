package main.csemachine;

public class ControlElement {

    private String type;        //gamma, lambda, ->, etc
    private String idName;      //if it's an identifier
    private String strValue; 
    private int intValue;
    private boolean boolValue;

   // private static 

    public ControlElement(String type){

        /* pseudo code
        if it's lambda, tau, eta, delta, e, conditional, throw exception 
        if it's something with <>, assign correct type
        if it's just gamma or any other normal operators - take from list or just make it last condition - 
            just store the string
        */

        if (type.length()>=4) {

            switch (type.substring(0,4)){

                case "<ID:":
                    this.type = "ID"; this.idName = type.substring(4,type.length()-1);
                    break;

                case "<INT":
                    this.type = "INT"; this.intValue = Integer.parseInt(type.substring(5,type.length()-1));
                    break;

                case "<STR":
                    this.type = "STR"; this.strValue = type.substring(5,type.length()-1);
                    break;

                default:
                    this.type = type;
                    break;
            }
            return;
        }
        this.type = type;
        return;

    }

    public String getIdName(){ return idName; }

    public String getType(){
        switch (type){
            case "INT":
                return ("INT: "+Integer.toString(intValue));

            case "STR":
                return (type+": "+strValue);

            case "ID":
                return (type + ": " + idName);

            default:
                return type;
        }
    }

}