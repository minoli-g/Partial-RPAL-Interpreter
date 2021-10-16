package main.nodes;

import main.nodes.*;

public class LambdaNode extends Node {
	
	public LambdaNode(int depth){
		super(depth);
	}

	public LambdaNode() { super(); }

	@Override
	public String getType() { return "lambda"; }
	
	@Override
	public Node getReplacement() {return this; }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {}
	
}