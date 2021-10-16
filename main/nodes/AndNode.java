package main.nodes;

import main.nodes.*;

public class AndNode extends Node {
	
	public AndNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() { return new AcceptedNode("="); }
	
	@Override
	public void attachStandardizedChildren(Node replacement) {

		Node cm = new AcceptedNode(",");
		Node tau = new AcceptedNode("tau");

		for (int i=0; i<this.numberOfChildren(); i++) {

			Node eq = this.getChildAt(i).standardizedVersion();
			Node x = eq.getChildAt(0).standardizedVersion();
			Node e = eq.getChildAt(1).standardizedVersion();

			cm.addChild(x);
			tau.addChild(e);
		}
		replacement.addChild(cm);
		replacement.addChild(tau);

		return;
	}
	
}