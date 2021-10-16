package main.nodes;

import main.nodes.*;

public class InfixNode extends Node {
	
	public InfixNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() { return new AcceptedNode("gamma"); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}