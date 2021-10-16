package main.nodes;

import main.nodes.*;

public class WhereNode extends Node {
	
	public WhereNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() {return new AcceptedNode("gamma");}
	
	@Override
	public void attachStandardizedChildren(Node replacement) {

		Node p = this.getChildAt(0).standardizedVersion();
		Node eq = this.getChildAt(1).standardizedVersion();

		Node x = eq.getChildAt(0).standardizedVersion();
		Node e = eq.getChildAt(1).standardizedVersion();

		LambdaNode ln = new LambdaNode();
		ln.addChild(x);
		ln.addChild(p);
		replacement.addChild(ln);
		replacement.addChild(e);
		return;
	}
	
}