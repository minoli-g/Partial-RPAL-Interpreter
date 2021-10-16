package main.nodes;

import main.nodes.*;

public class FcnFormNode extends Node {
	
	public FcnFormNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() { return new AcceptedNode("gamma"); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}