package main.nodes;

import main.nodes.*;

public class RecNode extends Node {
	
	public RecNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() {return new AcceptedNode("gamma");}
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}