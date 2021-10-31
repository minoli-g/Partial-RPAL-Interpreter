package main.csemachine.elements;

import main.csemachine.*;

import java.util.Stack;
import java.util.ArrayList;


public class EtaElement extends ControlElement {

    private LambdaElement lambdaElement; 

    public EtaElement(LambdaElement le){
        super("eta", true);
        this.lambdaElement = le;
    }

    public LambdaElement getLambdaElement(){
        return lambdaElement;
    }

}