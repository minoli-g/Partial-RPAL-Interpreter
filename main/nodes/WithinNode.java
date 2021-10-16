package main.nodes;

import main.nodes.*;

public class WithinNode extends Node {
	
	public WithinNode(int depth){
		super(depth);
	}
	
	@Override
	public Node getReplacement() {return new AcceptedNode("=");}
	
	@Override
	public void attachStandardizedChildren(Node replacement) {

		Node gn = new AcceptedNode("gamma");
		Node ln = new LambdaNode();

		Node eq1 = this.getChildAt(0).standardizedVersion();
		Node x1 = eq1.getChildAt(0);
		Node e1 = eq1.getChildAt(1);

		Node eq2 = this.getChildAt(1).standardizedVersion();
		Node x2 = eq2.getChildAt(0);
		Node e2 = eq2.getChildAt(1);

		replacement.addChild(x2);

		replacement.addChild(gn);
		gn.addChild(ln);
		ln.addChild(x1);
		ln.addChild(e2);
		gn.addChild(e1);

		return;

	}
	
}