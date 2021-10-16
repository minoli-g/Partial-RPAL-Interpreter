package main.nodes;

import main.nodes.*;

public class LambdaNode extends Node {
	
	public LambdaNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() {return new AcceptedNode("gamma"); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}