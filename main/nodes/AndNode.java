package main.nodes;

import main.nodes.*;

public class AndNode extends Node {
	
	public AndNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() { return new AcceptedNode("gamma"); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}