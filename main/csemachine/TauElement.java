package main.csemachine;

public class TauElement extends ControlElement {

    private int number;

    public TauElement(int number) { 
        super("tau");
        this.number = number; }
    
    public int getNumberOfElements(){ return number; }
}