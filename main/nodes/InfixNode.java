package main.nodes;

import main.nodes.*;

public class InfixNode extends Node {
	
	public InfixNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() { return new AcceptedNode("gamma"); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {

		Node e1 = this.getChildAt(0).standardizedVersion();
		Node n = this.getChildAt(1).standardizedVersion();
		Node e2 = this.getChildAt(2).standardizedVersion();

		Node gn = new AcceptedNode("gamma");
		gn.addChild(n);
		gn.addChild(e1);

		replacement.addChild(gn);
		replacement.addChild(e2);
		return;
	}
	
}