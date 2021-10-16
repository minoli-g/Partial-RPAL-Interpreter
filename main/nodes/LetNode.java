package main.nodes;

import main.nodes.*;

public class LetNode extends Node {
	
	public LetNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() { return new AcceptedNode("gamma");}
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}