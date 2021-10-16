package main.nodes;

import main.nodes.*;

public class LetNode extends Node {
	
	public LetNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() { return new AcceptedNode("gamma");}
	
	@Override
	public void attachStandardizedChildren(Node replacement) {

		Node D = this.getChildAt(0).standardizedVersion();
		Node x = D.getChildAt(0);
		Node e = D.getChildAt(1);
		Node p = this.getChildAt(1).standardizedVersion();

		LambdaNode ln = new LambdaNode(1);
		ln.addChild(x);
		ln.addChild(p);

		replacement.addChild(ln);
		replacement.addChild(e);

	}
	
}