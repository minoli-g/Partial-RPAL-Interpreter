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
    public void attachStandardizedChildren(Node replacement) {
        for (int i=0; i<this.numberOfChildren(); i++) {
            replacement.addChild(this.getChildAt(i).standardizedVersion());
        }
    }

    @Override
    public Node getReplacement(){ return new AcceptedNode(type,depth); }
}