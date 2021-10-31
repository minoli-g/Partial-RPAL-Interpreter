package main.csemachine.elements;

public class DeltaElement extends ControlElement {

    private int index;

    public DeltaElement(int index) {
        super("delta",true);
        this.index = index;
    }

    public int getIndex() { return index; }
    
}