package main.nodes;

import main.nodes.*;

public class WhereNode extends Node {
	
	public WhereNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() {return new AcceptedNode("gamma");}
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}