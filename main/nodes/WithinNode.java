package main.nodes;

import main.nodes.*;

public class WithinNode extends Node {
	
	public WithinNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() {return new AcceptedNode("gamma");}
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}