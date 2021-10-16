package main.nodes;

public class AcceptedNode extends Node {

    private String type;

    public AcceptedNode(String type, int depth) {
        super(depth);
        this.type=type;
    }

    public AcceptedNode(String type) { 
        super(); 
        this.type = type; 
    }

    @Override
    public String getType() { return type; }

    @Override
    public Node standardizedVersion() {
        //System.out.println("Node is already standardized.");
        return this;
    }

    @Override
    public void attachStandardizedChildren(Node replacement) {}

    @Override
    public Node getReplacement(){ return this; }
}